package com.jku.at.securehome.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Video could not be found")
public class VideoNotFoundException extends RuntimeException {
}
