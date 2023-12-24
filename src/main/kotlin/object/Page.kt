package `object`

import com.fasterxml.jackson.annotation.JsonProperty

data class Page(
    @field:JsonProperty("path")
    val path: String?,
    @field:JsonProperty("url")
    val url: String?,
    @field:JsonProperty("title")
    val title: String?,
    @field:JsonProperty("description")
    val description: String?,
    @field:JsonProperty("author_name")
    val authorName: String?,
    @field:JsonProperty("author_url")
    val authorUrl: String?,
    @field:JsonProperty("image_url")
    val imageUrl: String?,
    @field:JsonProperty("content")
    val content: List<Node>?,
    @field:JsonProperty("can_edit")
    val canEdit: Boolean?,
)
