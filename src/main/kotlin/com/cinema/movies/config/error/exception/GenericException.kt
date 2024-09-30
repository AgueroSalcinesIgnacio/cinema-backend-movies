package com.cinema.users.config.error.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.ErrorResponseException


class GenericException(message: String?, status: HttpStatus = HttpStatus.BAD_REQUEST) : ErrorResponseException(
    status,
    ProblemDetail.forStatusAndDetail(status, message), null
)
