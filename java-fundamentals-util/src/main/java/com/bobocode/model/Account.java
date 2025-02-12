package com.bobocode.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "email")
public class Account {
    public LocalDate getBirthday()
    {
        return birthday;
    }

    private Long id;
    private String firstName;
    private String lastName;

    public Long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public Sex getSex()
    {
        return sex;
    }

    public LocalDate getCreationDate()
    {
        return creationDate;
    }

    private String email;
    private LocalDate birthday;
    private Sex sex;
    private LocalDate creationDate;
    private BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance()
    {
        return balance;
    }

    public void setBalance(BigDecimal add) {
        this.balance=balance;
    }

}

