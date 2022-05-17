package com.deezer.repository;

import com.deezer.repository.entity.ArtistEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<ArtistEntity,String> {
}
