package com.pasechnik.movieland.common;

import java.beans.PropertyEditorSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyTypeConverter extends PropertyEditorSupport {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void setAsText(String text) throws IllegalArgumentException  {
        try {
            setValue(CurrencyType.getByName(text));
        }
        catch(IllegalArgumentException e) {
            logger.error("Error message  {} ", e);
            throw  e;
        }
    }
}