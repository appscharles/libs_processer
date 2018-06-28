package com.appscharles.libs.processer.callers;

/**
 * The type Result.
 */
public class CommanderResult {

    private Boolean error;

    private String output;

    public CommanderResult(Boolean error, String output) {
        this.error = error;
        this.output = output;
    }

    public Boolean isError() {
        return error;
    }

    /**
     * Getter for property 'output'.
     *
     * @return Value for property 'output'.
     */
    public String getOutput() {
        return output;
    }
}
