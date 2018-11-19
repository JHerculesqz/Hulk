package com.firelord.component.security.dao.tblright;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * TBLRightRepository
 */
public interface TBLRightRepository extends MongoRepository<TBLRight, String>, TBLRightRepositoryEx {

}
