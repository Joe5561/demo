package br.com.joe.demo.controller

import br.com.joe.demo.data.vo.v1.PersonVO
import br.com.joe.demo.service.PersonService
import br.com.joe.demo.util.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/person/v1")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON]
    )
    fun findById(@PathVariable(value = "id") id: Long): PersonVO{
        return service.findById(id)
    }

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON]
    )
    fun findAll(): List<PersonVO> {
        return service.findAll()
    }

    @PostMapping(
        produces = [MediaType.APPLICATION_JSON],
        consumes = [MediaType.APPLICATION_JSON]
    )
    fun create(@RequestBody person: PersonVO): PersonVO {
        return service.create(person)
    }
}