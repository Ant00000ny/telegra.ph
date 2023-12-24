package method

import com.fasterxml.jackson.core.type.TypeReference
import exception.TelegraphException
import `object`.UploadedFile
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import util.UPLOAD_BASE_URL
import util.defaultClient
import util.objectMapper
import java.io.File

/**
 * Non-standard api
 */
data class Upload(
    var file: File,
) {
    fun urlPath() = UPLOAD_BASE_URL

    fun deserializeResponse(responseJson: String): UploadedFile {
        val rootNode = objectMapper.readTree(responseJson)
        if (rootNode.isObject) {
            throw TelegraphException("Upload error: ${rootNode.get("error").asText()}")
        } else {
            return objectMapper.readValue(responseJson, object : TypeReference<List<UploadedFile>>() {}).first()
        }
    }

    fun sendRequest(): UploadedFile {
        val fileMediaType = when (file.extension) {
            "png" -> "image/png"
            "jpg" -> "image/jpeg"
            "gif" -> "image/gif"
            else -> throw TelegraphException("Unsupported file type")
        }.toMediaTypeOrNull()


        val request = Request.Builder()
            .url(urlPath())
            .post(
                MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart(
                        "file",
                        file.name,
                        file.readBytes().toRequestBody(fileMediaType)
                    )
                    .build()
            )
            .header("Content-Type", "multipart/form-data")
            .header("charset", Charsets.UTF_8.name())
            .build()

        return defaultClient
            .newCall(request)
            .execute()
            .let { it.body?.string() ?: throw TelegraphException("Response body is null") }
            .let { deserializeResponse(it) }
    }
}
