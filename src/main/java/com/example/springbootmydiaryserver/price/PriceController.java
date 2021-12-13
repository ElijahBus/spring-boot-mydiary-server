package com.example.springbootmydiaryserver.price;

import com.example.springbootmydiaryserver.price.enums.Currency;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prices")
@AllArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @PostMapping
    public Price savePrice() {
        return priceService.save(new PriceRequest(2000, Currency.EUR));
    }

}
