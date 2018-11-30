package com.pasechnik.movieland.common;


public class RequestAdditionalParam {
    private SortField sortField;
    private SortType sortType;

    public com.pasechnik.movieland.common.SortField getSortField() {
        return sortField;
    }

    public void setSortField(com.pasechnik.movieland.common.SortField sortField) {
        this.sortField = sortField;
    }

    public com.pasechnik.movieland.common.SortType getSortType() {
        return sortType;
    }

    public void setSortType(com.pasechnik.movieland.common.SortType sortType) {
        this.sortType = sortType;
    }
}
