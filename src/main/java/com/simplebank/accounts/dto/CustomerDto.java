package com.simplebank.accounts.dto;

import com.simplebank.accounts.entity.Accounts;
import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private String email;
    private String mobileNumber;
    private AccountsDto accountsDto;
}
/*
* The @Data annotation is part of the Lombok library, which is used to reduce boilerplate code in Java classes.
* When you annotate a class with @Data, Lombok automatically generates several commonly used methods for you.
* Specifically, @Data generates:

Getters and Setters: For all the fields in the class.
toString() Method: A method that returns a string representation of the object.
equals() and hashCode() Methods: Methods that are used to compare objects and to generate hash codes, respectively.
canEqual() Method: Used in the equals() method to ensure that the objects being compared are of the same type.
RequiredArgsConstructor: A constructor that initializes final fields and fields marked with @NonNull.
The @Data annotation is a convenient way to ensure that your data transfer objects (DTOs) have all the necessary methods
without manually writing them, which can help reduce errors and improve code readability.

Differences from Other Annotations:
@Getter and @Setter: These annotations are used to generate only the getter and setter methods for the fields.
If you only need these methods, you can use these annotations instead of @Data.
@ToString: This annotation generates the toString() method. If you only want to customize or generate the toString() method,
you can use this annotation separately.
@EqualsAndHashCode: This annotation generates the equals() and hashCode() methods.
Use it if you only need these methods without the others provided by @Data.
@AllArgsConstructor and @NoArgsConstructor: These annotations generate constructors with all arguments and no arguments,
respectively. They are useful if you need specific constructor behavior.
In summary, @Data is a comprehensive annotation that combines several other Lombok annotations to provide a full suite
of methods for a class, making it ideal for DTOs and other simple data-holding classes.

* */