package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.Account
import util.objectMapper

data class CreateAccount(
    @field:JsonProperty("short_name")
    var shortName: String? = null,
    @field:JsonProperty("name")
    var authorName: String? = null,
    @field:JsonProperty("url")
    var authorUrl: String? = null,
) : Method<Account> {
    override fun urlPath() = "createAccount"
    override fun deserializeResponse(response: String): Account {
        return objectMapper.readValue(response, Account::class.java)
    }
}
