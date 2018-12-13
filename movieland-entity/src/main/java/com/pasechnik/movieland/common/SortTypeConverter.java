package com.pasechnik.movieland.common;

import java.beans.PropertyEditorSupport;

public class SortTypeConverter extends PropertyEditorSupport {

    public void setAsText(String text) throws IllegalArgumentException {
        setValue(SortType.getByName(text));
    }
}