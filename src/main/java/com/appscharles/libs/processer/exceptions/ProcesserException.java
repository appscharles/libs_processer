package com.appscharles.libs.processer.exceptions;

/**
 * The type Updater exception.
 */
public class ProcesserException extends Exception {
    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7821375828146020432L;

    /**
     * Instantiates a new Updater exception.
     */
    public ProcesserException() {
        super();
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     */
    public ProcesserException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ProcesserException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param cause the cause
     */
    public ProcesserException(Throwable cause) {
        super(cause);
    }
}

