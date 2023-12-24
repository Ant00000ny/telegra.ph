package `object`

import com.fasterxml.jackson.annotation.JsonProperty

data class Account(
    @field:JsonProperty("short_name")
    val shortName: String,
    @field:JsonProperty("author_name")
    val authorName: String,
    @field:JsonProperty("author_url")
    val authorUrl: String,
    @field:JsonProperty("access_token")
    val accessToken: String,
    @field:JsonProperty("auth_url")
    val authUrl: String,
    @field:JsonProperty("page_count")
    val pageCount: Int,
)
