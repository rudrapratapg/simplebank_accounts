package com.simplebank.accounts.controller;

import com.simplebank.accounts.constants.AccountsConstants;
import com.simplebank.accounts.dto.CustomerDto;
import com.simplebank.accounts.dto.ErrorResponseDto;
import com.simplebank.accounts.dto.ResponseDto;
import com.simplebank.accounts.service.AccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CRUD rest apis for simple bank Accounts", description = "APIs for managing accounts")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class AccountsController {

    private AccountsService accountsService;

    @Operation(summary = "Create a new account", description = "Create a new account with the given details")
    @ApiResponse(responseCode = "201", description = "Account created successfully")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(summary = "Fetch an account", description = "Fetch an account with the given mobile number")
    @ApiResponse(responseCode = "200", description = "Account fetched successfully")
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam
                                                        @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                        String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @Operation(summary = "Update an account", description = "Update an account with the given details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account updated successfully"),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }

    @Operation(summary = "Delete an account", description = "Delete an account with the given mobile number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted successfully"),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam
                                                         @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                         String mobileNumber) {
        boolean deleted = accountsService.deleteAccount(mobileNumber);
        if(deleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
}
