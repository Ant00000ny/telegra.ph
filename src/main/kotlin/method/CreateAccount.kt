package method

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateAccount(
    @field:JsonProperty("short_name")
    val shortName: String,
    @field:JsonProperty("name")
    val authorName: String,
    @field:JsonProperty("url")
    val authorUrl: String,
) : Method {
    override fun getUrlPath() = "createAccount"
}
