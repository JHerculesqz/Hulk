package com.firelord.test.core.fw.spring.db.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TBLBookRepository extends ElasticsearchRepository<TBLBook, String>, TBLBookRepositoryEx {
    List<TBLBook> findByNameAndType(String strName, String strType);

    List<TBLBook> findByNameStartingWith(String strNamePrefix);
}
