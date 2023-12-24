package method

import util.BASE_URL
import util.defaultClient
import exception.TelegraphException
import util.objectMapper
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

interface Method<R : Any> {
    fun urlPath(): String

    fun sendRequest(): R {
        val request = Request.Builder()
            .url(BASE_URL + this.urlPath())
            .post(objectMapper.writeValueAsString(this).toRequestBody())
            .header("Content-Type", "application/json")
            .header("charset", Charsets.UTF_8.name())
            .build()

        return defaultClient
            .newCall(request)
            .execute()
            .let { it.body ?: throw TelegraphException("Response body is null") }
            .let { deserializeResponse(it.string()) }
    }

    fun deserializeResponse(response: String): R
}
