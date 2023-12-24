package method

import `object`.Node

data class CreatePage(
    val accessToken: String,
    val title: String,
    val content: List<Node>,
    val authorName: String,
    val authorUrl: String,
    val returnContent: Boolean,
)
