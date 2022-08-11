package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST, reason = "Volunteer Already Exists.")
public class VolunteerAlreadyExistsException extends RuntimeException{
}
