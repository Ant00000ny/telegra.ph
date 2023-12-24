package method

data class GetAccountInfo(
    val accessToken: String,
    val fields: List<String>,
)
