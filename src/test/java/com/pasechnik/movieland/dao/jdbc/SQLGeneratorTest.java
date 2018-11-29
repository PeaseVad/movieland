package com.pasechnik.movieland.dao.jdbc;

import com.pasechnik.common.RequestAdditionalParam;
import com.pasechnik.common.SortField;
import com.pasechnik.common.SortType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SQLGeneratorTest {

    @Test
    public void testAddSortingToSQL() {
        String expectedSQL ="select id, movie_name_rus,movie_name_native,release_date,rating,price,poster from movie order by rating desc";
        RequestAdditionalParam requestAdditionalParam = new RequestAdditionalParam();
        requestAdditionalParam.setSortField(SortField.RATING);
        requestAdditionalParam.setSortType(SortType.DESC);
        String actualSQL = SQLGenerator.addSortingToSQL("select id, movie_name_rus,movie_name_native,release_date,rating,price,poster from movie",requestAdditionalParam);
        assertEquals(expectedSQL,actualSQL);
    }
}