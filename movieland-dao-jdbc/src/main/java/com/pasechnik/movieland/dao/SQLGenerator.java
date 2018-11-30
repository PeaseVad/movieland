package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.common.RequestAdditionalParam;

public class SQLGenerator {
    public static String addSortingToSQL(String sql, RequestAdditionalParam requestAdditionalParam) {
        String withSortingSQL;

        String sortField = requestAdditionalParam.getSortField().value();
        String sortType = requestAdditionalParam.getSortType().value();
        withSortingSQL = sql + " order by " + sortField + " " + sortType;

        return withSortingSQL;
    }
}
