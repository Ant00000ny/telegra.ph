package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.Node
import `object`.Page
import `object`.TelegraphResponse
import objectMapper

data class CreatePage(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("title")
    var title: String? = null,
    @field:JsonProperty("content")
    var content: List<Node>? = null,
    @field:JsonProperty("author_name")
    var authorName: String? = null,
    @field:JsonProperty("author_url")
    var authorUrl: String? = null,
    @field:JsonProperty("return_content")
    var returnContent: Boolean? = null,
) : Method<Page> {
    override fun urlPath() = "createPage"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<Page> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<Page>>() {})
    }
}
