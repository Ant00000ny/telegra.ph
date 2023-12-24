package `object`

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue

data class UploadedFile(
    @field:JsonValue
    @field:JsonProperty("src")
    var src: String,
) {
    fun url() = "https://telegra.ph$src"
}
