package com.isilbolatbas.covid.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isilbolatbas.covid.model.Haber;

@Repository
public interface HaberRepository extends MongoRepository<Haber, String> {

}
