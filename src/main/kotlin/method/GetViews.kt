package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.PageViews
import util.objectMapper

data class GetViews(
    @field:JsonProperty("path")
    var path: String? = null,
    @field:JsonProperty("year")
    var year: Int? = null,
    @field:JsonProperty("month")
    var month: Int? = null,
    @field:JsonProperty("day")
    var day: Int? = null,
    @field:JsonProperty("hour")
    var hour: Int? = null,
) : Method<PageViews> {
    override fun urlPath() = "getViews"
    override fun deserializeResponse(response: String): PageViews {
        return objectMapper.readValue(response, PageViews::class.java)
    }
}
