package br.com.joe.demo.service

import br.com.joe.demo.controller.PersonController
import br.com.joe.demo.data.vo.v1.PersonVO
import br.com.joe.demo.exception.ResourceNotFoundException
import br.com.joe.demo.mapper.DozerMapper
import br.com.joe.demo.model.Person
import br.com.joe.demo.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person")
        var person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        val personVO: PersonVO = DozerMapper.parseObject(person, PersonVO::class.java)
        val withSelfRelationSet = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRelationSet)
        return personVO
    }

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people!")
        val persons = repository.findAll()
        val vos = DozerMapper.parseListObject(persons, PersonVO::class.java)
        for (person in vos){
            val withSelfRelationSet = linkTo(PersonController::class.java).slash(person.key).withSelfRel()
            person.add(withSelfRelationSet)
        }
        return vos
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating one person ${person.firstName}")
        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
        val personVO: PersonVO =  DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
        val withSelfRelationSet = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRelationSet)
        return personVO
    }

    fun update(person: PersonVO): PersonVO{
        logger.info("Updating one person ${person.key}")
        val entity = repository.findById(person.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        val personVO: PersonVO = DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
        val withSelfRelationSet = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRelationSet)
        return personVO
    }

    fun delete(id: Long){
        logger.info("Deleting one person $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}