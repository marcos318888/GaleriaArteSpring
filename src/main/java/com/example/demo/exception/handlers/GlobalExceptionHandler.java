package com.example.demo.exception.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.ArtworkCreationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ArtworkCreationException.class)
	public ProblemDetail handleBookNotFoundException(ArtworkCreationException a) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, a.getMessage());
		problemDetail.setTitle("Error el artista no es de elite");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Artwork");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	
}
