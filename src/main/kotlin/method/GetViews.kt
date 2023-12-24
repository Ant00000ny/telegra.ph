package method

import com.fasterxml.jackson.annotation.JsonProperty

data class GetViews(
    @field:JsonProperty("path")
    val path: String,
    @field:JsonProperty("year")
    val year : Int,
    @field:JsonProperty("month")
    val month : Int,
    @field:JsonProperty("day")
    val day : Int,
    @field:JsonProperty("hour")
    val hour : Int,
) : Method {
    override fun getUrlPath() = "getViews"
}
