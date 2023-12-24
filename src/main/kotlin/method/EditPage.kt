package method

import `object`.Node

data class EditPage(
    val accessToken: String,
    val path: String,
    val title: String,
    val content: List<Node>,
    val authorName: String,
    val authorUrl: String,
    val returnContent: Boolean,
)
