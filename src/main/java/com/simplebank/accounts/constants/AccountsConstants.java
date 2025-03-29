package com.simplebank.accounts.constants;

public class AccountsConstants {

    private AccountsConstants() {
     //   throw new IllegalStateException("Utility class");
    }

    public static final String SAVINGS="SAVINGS";
    public static final String ADDRESS="123 Main Street, New York, NY 10030";
    public static final String STATUS_200="200";
    public static final String MESSAGE_200="Request processed successfully";
    public static final String STATUS_201="201";
    public static final String MESSAGE_201="Account created successfully";
    public static final String MESSAGE_201_UPDATE="Account updated successfully";
    public static final String STATUS_400="400";
    public static final String MESSAGE_400="Bad Request";
    public static final String STATUS_417="417";
    public static final String MESSAGE_417_UPDATE="Update Operation failed. Please try again or contact Dev team";
    public static final String MESSAGE_417_DELETE="Delete Operation failed. Please try again or contact Dev team";
    public static final String STATUS_404="404";
    public static final String MESSAGE_404="Resource not found";
    public static final String STATUS_500="500";
    public static final String MESSAGE_500="An error occurred. Please try again or contact Dev team";
    public static final String SYSTEM="system";
    //whenever using 'static final' it is a good practise to keep field names in uppercase
}
