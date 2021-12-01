package com.example.springbootmydiaryserver.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Table(name = "publication_house")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PublicationHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Book book;

    public PublicationHouse(String name, Book book) {
        this.name = name;
        this.book = book;
    }

}