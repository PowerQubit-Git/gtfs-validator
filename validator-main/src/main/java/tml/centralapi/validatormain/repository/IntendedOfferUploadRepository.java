package tml.centralapi.validatormain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tml.centralapi.validatormain.model.IntendedOfferUpload;

public interface IntendedOfferUploadRepository extends MongoRepository<IntendedOfferUpload, String> {
}