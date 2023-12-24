package `object`

data class TelegraphResponse<T>(
    val ok: String,
    val error: String,
    val result: String,
)
