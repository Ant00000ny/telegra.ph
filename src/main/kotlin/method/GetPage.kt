package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.Page
import util.objectMapper

data class GetPage(
    @field:JsonProperty("path")
    var path: String? = null,
    @field:JsonProperty("return_content")
    var returnContent: Boolean? = null,
) : Method<Page> {
    override fun urlPath() = "getPage"
    override fun deserializeResponse(response: String): Page {
        return objectMapper.readValue(response, Page::class.java)
    }
}
