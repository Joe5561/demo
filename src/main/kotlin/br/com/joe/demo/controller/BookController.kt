package br.com.joe.demo.controller

import br.com.joe.demo.data.vo.v1.BookVO
import br.com.joe.demo.service.BookService
import br.com.joe.demo.util.MediaType.APPLICATION_JSON
import br.com.joe.demo.util.MediaType.APPLICATION_XML
import br.com.joe.demo.util.MediaType.APPLICATION_YML
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "Endpoints for managing book's")
class BookController {

    @Autowired
    private lateinit var service: BookService

    @GetMapping(
        value = ["/{id}"],
        produces = [APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML]
    )
    @Operation(
        summary = "Finds a Book", description = "Finds a Book",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = BookVO::class)))
                ]
            ),
            ApiResponse(
                description = "No content", responseCode = "204",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request", responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized", responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Not Found", responseCode = "404",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error", responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            )
        ]
    )
    fun findById(@PathVariable(value = "id") id: Long): BookVO {
        return service.findById(id)
    }

    @GetMapping(
        produces = [APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML]
    )
    @Operation(
        summary = "Find all Book's", description = "Find all Book's",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]
            ),
            ApiResponse(
                description = "No content", responseCode = "204",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request", responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized", responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Not Found", responseCode = "404",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error", responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            )
        ]
    )
    fun findAll(): List<BookVO> {
        return service.findAll()
    }

    @PostMapping(
        produces = [APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML],
        consumes = [APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML]
    )
    @Operation(
        summary = "Adds a new Book", description = "Adds a new Book",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request", responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized", responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error", responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            )
        ]
    )
    fun create(@RequestBody book: BookVO): BookVO {
        return service.create(book)
    }

    @PutMapping(
        produces = [APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML],
        consumes = [APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML]
    )
    @Operation(
        summary = "Updates a Book's information", description = "Updates a Book's information",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request", responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized", responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Not Found", responseCode = "404",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error", responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            )
        ]
    )
    fun update(@PathVariable id: Long, @RequestBody book: BookVO): BookVO {
        book.key = id
        return service.update(book)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML]
    )
    @Operation(
        summary = "Deletes a Book", description = "Deletes a Book",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "No content", responseCode = "204",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request", responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized", responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Not Found", responseCode = "404",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error", responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            )
        ]
    )
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}