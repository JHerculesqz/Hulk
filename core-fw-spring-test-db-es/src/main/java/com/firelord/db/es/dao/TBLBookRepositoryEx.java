package com.firelord.db.es.dao;

import java.util.List;

public interface TBLBookRepositoryEx {
    List<TBLBook> pagingByName(String strName, int iPage, int iLimit);
}
