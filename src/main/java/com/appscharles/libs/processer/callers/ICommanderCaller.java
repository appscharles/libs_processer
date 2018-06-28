package com.appscharles.libs.processer.callers;

import com.appscharles.libs.processer.exceptions.ProcesserException;

/**
 * The interface Commander caller.
 */
public interface ICommanderCaller {

    /**
     * Call string.
     *
     * @return the string
     * @throws ProcesserException the processer exception
     */
    CommanderResult call(String command) throws ProcesserException;
}
