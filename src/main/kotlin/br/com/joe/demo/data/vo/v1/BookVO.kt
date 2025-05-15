package br.com.joe.demo.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel
import java.util.Date

@JsonPropertyOrder("id", "author", "launchDate", "price", "title")
data class BookVO(

    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,

    @field:JsonProperty("author")
    var author: String = "",

    @field:JsonProperty("launchDate")
    var launchDate: Date? = null,

    @field:JsonProperty("price")
    var price: Double = 0.0,

    @field:JsonProperty("title")
    var title: String = ""

): RepresentationModel<BookVO>()
