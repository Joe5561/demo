package br.com.joe.demo.mapper.custom

import br.com.joe.demo.model.Book
import org.springframework.stereotype.Service

@Service
class BookMapper {

    fun mapEntityToVo(book: Book): Book {

        val vo = Book()

        vo.id = book.id
        vo.author = book.author
        vo.launchDate = book.launchDate
        vo.price = book.price
        vo.title = book.title

        return vo
    }

    fun mapVoToEntity(book: Book): Book {

        val entity = Book()

        entity.id = book.id
        entity.author = book.author
        entity.launchDate = book.launchDate
        entity.price = book.price
        entity.title = book.title

        return entity
    }
}