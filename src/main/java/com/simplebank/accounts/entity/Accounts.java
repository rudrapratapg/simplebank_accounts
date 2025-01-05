package com.simplebank.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
public class Accounts extends BaseEntity {

    //reference key / foreign key
    private Long customerId;

    @Id
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
