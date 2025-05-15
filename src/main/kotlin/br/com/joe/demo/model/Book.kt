package br.com.joe.demo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "books")
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "author", nullable = false, length = 80 )
    var author: String = "",

    @Column(name = "launch_date", nullable = false)
    var launchDate: Date? = null,

    @Column(name = "price", nullable = false)
    var price: Double = 0.0,

    @Column(name = "title", nullable = false, length = 80)
    var title: String = ""

)
