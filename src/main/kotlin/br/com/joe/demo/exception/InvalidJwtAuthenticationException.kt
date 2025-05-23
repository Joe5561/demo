package br.com.joe.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.FORBIDDEN)
class InvalidJwtAuthenticationException(exception: String?)
    : AuthenticationException(exception)