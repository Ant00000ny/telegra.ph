package `object`

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode

data class TelegraphResponse<T>(
    @field:JsonProperty("ok")
    val ok: Boolean,
    @field:JsonProperty("error")
    val error: String?,
    @field:JsonProperty("result")
    val result: JsonNode?,
)
