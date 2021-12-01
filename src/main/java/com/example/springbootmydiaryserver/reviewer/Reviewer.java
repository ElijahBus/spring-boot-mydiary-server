package com.example.springbootmydiaryserver.reviewer;

import com.example.springbootmydiaryserver.price.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "reviewer_price",
            joinColumns = @JoinColumn(name = "reviewer_id"),
            inverseJoinColumns = @JoinColumn(name = "price_id")
    )
    private List<Price> prices;

    public Reviewer(String name) {
        this.name = name;
    }

    public Reviewer(String name, List<Price> prices) {
        this.name = name;
        this.prices = prices;
    }
}
