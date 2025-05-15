package br.com.joe.demo.mapper.custom

import br.com.joe.demo.data.vo.v2.PersonVO2
import br.com.joe.demo.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntityToVo(person: Person): PersonVO2 {

        val vo = PersonVO2()
        vo.id = person.id
        vo.address = person.address
        vo.birthDay = Date()
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.gender = person.gender

        return vo

    }

    //fun mapVoToEntity(person: PersonVO2 do pacote v2): Person
    fun mapVoToEntity(person: PersonVO2): Person {
        val entity = Person()

        entity.id = person.id
        entity.address = person.address
        //entity.birthDay = Date()
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.gender = person.gender

        return entity

    }


}