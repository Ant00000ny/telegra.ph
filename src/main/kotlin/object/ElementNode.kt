package `object`

import com.fasterxml.jackson.annotation.JsonProperty

data class ElementNode(
    @field:JsonProperty("tag")
    var tag: String? = null,
    @field:JsonProperty("attrs")
    var attrs: Map<String, String>? = null,
    @field:JsonProperty("children")
    var children: List<Node>? = null,
) : Node()
