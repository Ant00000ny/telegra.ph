package `object`

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue

data class TextNode(
    @field:JsonValue
    @field:JsonProperty("content")
    val content: String?,
) : Node()
