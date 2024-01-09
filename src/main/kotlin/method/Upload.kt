package method

import com.fasterxml.jackson.core.type.TypeReference
import exception.TelegraphException
import `object`.UploadedFile
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import util.UPLOAD_BASE_URL
import util.defaultClient
import util.objectMapper
import java.security.MessageDigest

/**
 * Non-standard api
 */
data class Upload(
    val imageBytes: ByteArray,
    var imageFormat: String,
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

    @OptIn(ExperimentalStdlibApi::class)
    fun sendRequest(): UploadedFile {
        val fileMediaType = "image/" + when (imageFormat) {
            "jpg" -> "jpeg"
            else -> imageFormat
        }


        val request = Request.Builder()
            .url(urlPath())
            .post(
                MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart(
                        "file",
                        MessageDigest.getInstance("MD5").digest(imageBytes).toHexString(),
                        imageBytes.toRequestBody(fileMediaType.toMediaType())
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Upload

        if (!imageBytes.contentEquals(other.imageBytes)) return false
        if (imageFormat != other.imageFormat) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imageBytes.contentHashCode()
        result = 31 * result + imageFormat.hashCode()
        return result
    }
}
