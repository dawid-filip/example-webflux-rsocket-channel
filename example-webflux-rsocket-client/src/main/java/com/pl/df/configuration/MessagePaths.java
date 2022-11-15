package com.pl.df.configuration;

public enum MessagePaths {

    /** channel */
    MESSAGE_CHANNEL ("channel"),

    /** object-channel */
    OBJECT_MESSAGE_CHANNEL ("object-channel");

    private String value;

    MessagePaths(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
