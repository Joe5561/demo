package br.com.joe.demo.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping

@JsonPropertyOrder("id", "address", "fist_name", "last_name", "gender")
data class PersonVO (

    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,

    @field:JsonProperty("fist_name")
    var firstName: String = "",

    @field:JsonProperty("last_name")
    var lastName: String = "",

    @field:JsonProperty("address")
    var address: String = "",

    @field:JsonProperty("gender")
    var gender: String = ""
)