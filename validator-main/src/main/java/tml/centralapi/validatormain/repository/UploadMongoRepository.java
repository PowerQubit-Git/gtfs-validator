package tml.centralapi.validatormain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tml.centralapi.validatormain.model.UploadHistoricMongo;

public interface UploadMongoRepository extends MongoRepository<UploadHistoricMongo, String> {
}