package com.firelord.component.security.dao.tbluser;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * TBLUserRepository
 */
public interface TBLUserRepository extends MongoRepository<TBLUser, String>, TBLUserRepositoryEx {

}
