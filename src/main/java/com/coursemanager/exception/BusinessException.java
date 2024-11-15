package com.coursemanager.exception;

import com.coursemanager.messages.MessageEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    private String code;
    private HttpStatus httpStatus;

    public BusinessException(MessageEnum message, String messageParam, HttpStatus httpStatus) {
        super(messageParam != null ?
                String.format(message.getMessage(), messageParam) :
                    message.getMessage().split(":")[0]);

        this.code = message.getCode();
        this.httpStatus = httpStatus;
    }
}
