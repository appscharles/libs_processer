package com.appscharles.libs.processer.exceptions;

/**
 * The type Updater exception.
 */
public class TaskerException extends Exception {
    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7821375828146020432L;

    /**
     * Instantiates a new Updater exception.
     */
    public TaskerException() {
        super();
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     */
    public TaskerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public TaskerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param cause the cause
     */
    public TaskerException(Throwable cause) {
        super(cause);
    }
}

