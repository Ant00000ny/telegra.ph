package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.Node
import `object`.Page
import util.objectMapper

data class EditPage(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("path")
    var path: String? = null,
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
    override fun urlPath() = "editPage"
    override fun deserializeResponse(response: String): Page {
        return objectMapper.readValue(response, Page::class.java)
    }
}
