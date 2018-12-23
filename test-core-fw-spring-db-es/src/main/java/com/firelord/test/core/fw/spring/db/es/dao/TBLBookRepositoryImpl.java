package com.firelord.test.core.fw.spring.db.es.dao;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;

public class TBLBookRepositoryImpl implements TBLBookRepositoryEx {
    //#region Fields

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    //#endregion

    //#region pagingByName

    @Override
    public List<TBLBook> pagingByName(String strName, int iPage, int iLimit) {
        SortBuilder oSortBuilder = SortBuilders.fieldSort("name")   //排序字段
                .order(SortOrder.DESC);   //排序方式

        SearchQuery oSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", strName))
                .withPageable(new PageRequest(iPage, iLimit))
                .withSort(oSortBuilder)
                .build();
        return this.elasticsearchTemplate.queryForList(oSearchQuery, TBLBook.class);
    }

    //#endregion
}
