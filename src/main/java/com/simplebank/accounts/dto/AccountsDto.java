package com.simplebank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Accounts", description = "Details of the account")
public class AccountsDto {

    @Schema(description = "Account number of simplebank", example = "1234567890")
    @NotEmpty(message = "Account number can not be null or empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number should be 10 digits")
    private Long accountNumber;

    @Schema(description = "Type of account", example = "Savings")
    @NotEmpty(message = "Account type can not be null or empty")
    private String accountType;

    @Schema(description = "Branch address of the account", example = "123, Main Street, New York")
    @NotEmpty(message = "Branch address can not be null or empty")
    private String branchAddress;
}
