package org.breve.repositories;

import org.breve.models.URLS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface URLRepository extends MongoRepository<URLS, String> {
    @Query("{ 'customCode' : ?0 }")
    Optional<URLS> findOneByCustomCode(String customCode);
}

