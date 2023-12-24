package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.Account
import util.objectMapper

data class EditAccountInfo(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("short_name")
    var shortName: String? = null,
    @field:JsonProperty("author_name")
    var authorName: String? = null,
    @field:JsonProperty("author_url")
    var authorUrl: String? = null,
) : Method<Account> {
    override fun urlPath() = "editAccountInfo"
    override fun deserializeResponse(response: String): Account {
        return objectMapper.readValue(response, Account::class.java)
    }
}
