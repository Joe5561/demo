package br.com.joe.demo.service

import br.com.joe.demo.data.vo.v1.PersonVO
import br.com.joe.demo.exception.ResourceNotFoundException
import br.com.joe.demo.mapper.DozerMapper
import br.com.joe.demo.mapper.custom.PersonMapper
import br.com.joe.demo.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person")
        var person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people!")
        val persons = repository.findAll()
        return DozerMapper.parseListObject(persons, PersonVO::class.java)
    }

}