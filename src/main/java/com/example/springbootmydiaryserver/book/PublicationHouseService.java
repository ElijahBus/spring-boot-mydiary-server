package com.example.springbootmydiaryserver.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PublicationHouseService {

    private final PublicationHouseRepository publicationHouseRepository;

    public PublicationHouse save(PublicationHouse publicationHouse) {
        return publicationHouseRepository.save(publicationHouse);
    }
}

