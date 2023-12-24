package `object`

import com.fasterxml.jackson.annotation.JsonProperty

data class ElementNode(
    @field:JsonProperty("name")
    val name: String?,
    @field:JsonProperty("attributes")
    val attributes: Map<String, String>?,
    @field:JsonProperty("children")
    val children: List<Node>?,
) : Node()
