package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.PageList
import util.objectMapper

data class GetPageList(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("offset")
    var offset: Int? = null,
    @field:JsonProperty("limit")
    var limit: Int? = null,
) : Method<PageList> {
    override fun urlPath() = "getPageList"
    override fun deserializeResponse(response: String): PageList {
        return objectMapper.readValue(response, PageList::class.java)
    }
}
