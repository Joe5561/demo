package br.com.joe.demo.service

import br.com.joe.demo.controller.BookController
import br.com.joe.demo.data.vo.v1.BookVO
import br.com.joe.demo.exception.ResourceNotFoundException
import br.com.joe.demo.mapper.DozerMapper
import br.com.joe.demo.model.Book
import br.com.joe.demo.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo

@Service
class BookService {

    @Autowired
    private lateinit var repository: BookRepository
    private val logger = Logger.getLogger(BookService::class.java.name)

    fun findById(id: Long): BookVO {
        logger.info("Finding one book")
        val book = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        val bookVO: BookVO = DozerMapper.parseObject(book, BookVO::class.java)
        val withSelfRelationSet = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRelationSet)
        return bookVO
    }

    fun findAll(): List<BookVO> {
        logger.info("Finding all book's")
        val books = repository.findAll()
        val vos = DozerMapper.parseListObject(books, BookVO::class.java)
        for (book in vos) {
            val withSelfRelationSet = linkTo(BookController::class.java).slash(book.key).withSelfRel()
            book.add(withSelfRelationSet)
        }
        return vos
    }

    fun create(book: BookVO): BookVO {
        logger.info("Creating a new book")
        val entity = DozerMapper.parseObject(book, Book::class.java)
        val bookVO = DozerMapper.parseObject(repository.save(entity), BookVO::class.java)
        val withSelfRelationSet = linkTo(BookController::class.java).slash(book.key).withSelfRel()
        book.add(withSelfRelationSet)
        return bookVO
    }

    fun update(book: BookVO): BookVO {
        logger.info("Updating a book")
        val entity = repository.findById(book.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.author = book.author
        entity.launchDate = book.launchDate
        entity.price = book.price
        entity.title = book.title

        val bookVO: BookVO = DozerMapper.parseObject(repository.save(entity), BookVO::class.java)
        val withSelfRelationSet = linkTo(BookController::class.java).slash(book.key).withSelfRel()
        bookVO.add(withSelfRelationSet)
        return bookVO

    }

    fun delete(id: Long) {
        logger.info("Deleting a book")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }

}