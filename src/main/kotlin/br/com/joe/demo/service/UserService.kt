package br.com.joe.demo.service

import br.com.joe.demo.exception.UserNotFoundException
import br.com.joe.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class UserService(@field:Autowired var repository: UserRepository): UserDetailsService {
    private val logger = Logger.getLogger(BookService::class.java.name)

    override fun loadUserByUsername(username: String?): UserDetails {
        logger.info("Finding one User by Username $username")
        val user = repository.findByUserName(username!!)
        return user ?: throw UserNotFoundException("Username $username not found")
    }
}