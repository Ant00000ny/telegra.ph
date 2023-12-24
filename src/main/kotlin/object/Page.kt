package `object`

data class Page(
    val path: String,
    val url: String,
    val title: String,
    val description: String,
    val authorName: String,
    val authorUrl: String,
    val imageUrl: String,
    val content: List<Node>,
    val canEdit: Boolean,
)
