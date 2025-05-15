package br.com.joe.demo.data.vo.v2

import java.util.Date

data class PersonVO2 (
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
    var birthDay: Date? = null
)