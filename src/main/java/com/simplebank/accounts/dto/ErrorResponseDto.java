package com.simplebank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(name = "ErrorResponse", description = "Schema to hold error response information")
public class ErrorResponseDto {

    @Schema(description = "API path where error occurred", example = "/simplebank/accounts")
    private String apiPath;

    @Schema(description = "HTTP status code of the error", example = "400")
    private HttpStatus errorCode;

    @Schema(description = "Error message", example = "Invalid account number")
    private String errorMessage;

    @Schema(description = "Time when error occurred", example = "2021-09-01T10:00:00")
    private LocalDateTime errorTime;

}
