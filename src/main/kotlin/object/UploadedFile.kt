package `object`

import com.fasterxml.jackson.annotation.JsonProperty

data class UploadedFile(
    @field:JsonProperty("src")
    var src: String,
) {
    fun url() = "https://telegra.ph$src"
}
