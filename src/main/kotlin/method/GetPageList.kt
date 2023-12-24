package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.PageList
import `object`.TelegraphResponse
import objectMapper

data class GetPageList(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("offset")
    var offset: Int? = null,
    @field:JsonProperty("limit")
    var limit: Int? = null,
) : Method<PageList> {
    override fun urlPath() = "getPageList"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<PageList> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<PageList>>() {})
    }
}
