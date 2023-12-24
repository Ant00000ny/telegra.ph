package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.Page
import `object`.TelegraphResponse
import objectMapper

data class GetPage(
    @field:JsonProperty("path")
    var path: String? = null,
    @field:JsonProperty("return_content")
    var returnContent: Boolean? = null,
) : Method<Page> {
    override fun urlPath() = "getPage"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<Page> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<Page>>() {})
    }
}
