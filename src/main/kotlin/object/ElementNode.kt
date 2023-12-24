package `object`

data class ElementNode(
    val name: String,
    val attributes: Map<String, String>,
    val children: List<Node>,
) : Node()
