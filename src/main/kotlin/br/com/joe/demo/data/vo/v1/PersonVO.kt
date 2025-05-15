package br.com.joe.demo.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.hibernate.metamodel.RepresentationMode
import org.springframework.hateoas.RepresentationModel

@JsonPropertyOrder("id", "firstName", "lastName", "address", "gender")
data class PersonVO (

    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,

    @field:JsonProperty("firstName")
    var firstName: String = "",

    @field:JsonProperty("lastName")
    var lastName: String = "",

    @field:JsonProperty("address")
    var address: String = "",

    @field:JsonProperty("gender")
    var gender: String = ""
): RepresentationModel<PersonVO>()