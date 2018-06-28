package com.appscharles.libs.processer.closers;

import com.appscharles.libs.processer.exceptions.ProcesserException;

/**
 * The interface Child closer.
 */
public interface IChildCloser {

    /**
     * Close.
     *
     * @throws ProcesserException the tasker exception
     */
    void close()throws ProcesserException;
}
