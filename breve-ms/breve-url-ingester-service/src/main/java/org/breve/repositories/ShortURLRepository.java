package org.breve.repositories;

import org.breve.models.URLS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortURLRepository extends MongoRepository<URLS, String> {
    @Query("{ 'customCode' : ?0 }")
    List<URLS> findOneByCustomCode(String customCode);
}

