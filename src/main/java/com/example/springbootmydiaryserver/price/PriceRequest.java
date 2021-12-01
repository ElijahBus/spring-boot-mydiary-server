package com.example.springbootmydiaryserver.price;


import com.example.springbootmydiaryserver.price.enums.Currency;
import com.example.springbootmydiaryserver.reviewer.Reviewer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
public class PriceRequest {

    @NotNull
    private double amount;

    @NotNull
    private Currency currency;

    @NotNull
    private List<Reviewer> reviewers;

    public PriceRequest(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
