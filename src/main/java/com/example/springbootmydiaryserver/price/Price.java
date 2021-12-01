package com.example.springbootmydiaryserver.price;

import com.example.springbootmydiaryserver.price.enums.Currency;
import com.example.springbootmydiaryserver.reviewer.Reviewer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Price {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double amount;

  /**
   * You can choose between STRING and ORDINAL depending on whether you would like to index data
   * which will work fine with ORDINAL but then, the problem will be when you would like to add
   * more values to the enums, you should be careful about that coz, adding wrong values to the enum 
   * may result into a data mismatch in the database, the ordinal index will still be stored but won't be mapped
   * to its correct value
   */
  @Enumerated(EnumType.STRING)
  private Currency currency;

  @ManyToMany(mappedBy = "prices")
  List<Reviewer> reviewers;

  public Price(double amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public Price(double amount, Currency currency, List<Reviewer> reviewers) {
    this.amount = amount;
    this.currency = currency;
    this.reviewers = reviewers;
  }
}
