package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.Node

data class CreatePage(
    @field:JsonProperty("access_token")
    val accessToken: String,
    @field:JsonProperty("title")
    val title: String,
    @field:JsonProperty("content")
    val content: List<Node>,
    @field:JsonProperty("author_name")
    val authorName: String,
    @field:JsonProperty("author_url")
    val authorUrl: String,
    @field:JsonProperty("return_content")
    val returnContent: Boolean,
) : Method {
    override fun getUrlPath() = "createPage"
}
