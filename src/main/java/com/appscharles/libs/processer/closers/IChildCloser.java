package com.appscharles.libs.processer.closers;

import com.appscharles.libs.processer.exceptions.TaskerException;

/**
 * The interface Child closer.
 */
public interface IChildCloser {

    /**
     * Close.
     *
     * @throws TaskerException the tasker exception
     */
    void close()throws TaskerException;
}
