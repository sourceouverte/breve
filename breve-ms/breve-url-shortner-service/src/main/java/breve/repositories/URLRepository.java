package breve.repositories;

import breve.models.URL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URLRepository extends MongoRepository<URL, String> {
    URL findByCustomCode(String customCode);
}

