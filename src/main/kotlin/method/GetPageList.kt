package method

data class GetPageList(
    val accessToken: String,
    val offset: Int,
    val limit: Int,
)
