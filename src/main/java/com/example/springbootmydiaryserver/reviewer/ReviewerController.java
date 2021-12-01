package com.example.springbootmydiaryserver.reviewer;

import com.example.springbootmydiaryserver.price.Price;
import com.example.springbootmydiaryserver.price.PriceRepository;
import com.example.springbootmydiaryserver.price.PriceRequest;
import com.example.springbootmydiaryserver.price.PriceService;
import com.example.springbootmydiaryserver.price.enums.Currency;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/reviewers")
@AllArgsConstructor
public class ReviewerController {

    private final ReviewerRepository reviewerRepository;
    private  final PriceService priceService;
    private final PriceRepository priceRepository;

    @PostMapping
    public String saveNewReviewer() {
        // Create prices
        Price price1 = priceService.save(new PriceRequest(10, Currency.EUR));
        Price price2 = priceService.save(new PriceRequest(30, Currency.USD));

        ArrayList<Price> prices = new ArrayList<>();
        prices.add(price1);
        prices.add(price2);

        // Add reviewer to the created prices
        Reviewer reviewer = new Reviewer("Winner", prices);
        reviewerRepository.save(reviewer);

        //// Bi-directional relationship
        Price price3 = new Price();
        price3.setAmount(50);
        price3.setCurrency(Currency.EUR);

        Reviewer reviewer1 = new Reviewer();
        reviewer1.setName("Josh");

        Reviewer reviewer2 = new Reviewer();
        reviewer2.setName("Irenee");

        ArrayList<Reviewer> reviewersList = new ArrayList<>();
        reviewersList.add(reviewer1);
        reviewersList.add(reviewer2);

        price3.setReviewers(reviewersList);
        reviewer1.setPrices(prices);
        reviewer2.setPrices(prices);

        reviewerRepository.save(reviewer1);
        reviewerRepository.save(reviewer2);

        priceRepository.save(price3);


        return "Review Saved";
    }

}
