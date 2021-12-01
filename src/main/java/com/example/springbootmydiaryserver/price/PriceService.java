package com.example.springbootmydiaryserver.price;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceService {

    private PriceRepository priceRepository;

    public Price save(PriceRequest priceRequest) {
        return priceRepository.save(new Price(
                priceRequest.getAmount(),
                priceRequest.getCurrency()
        ));
    }

    public Price savePriceWithReviewers(PriceRequest request) {
        return priceRepository.save(new Price(
                request.getAmount(),
                request.getCurrency(),
                request.getReviewers()
        ));
    }
}
