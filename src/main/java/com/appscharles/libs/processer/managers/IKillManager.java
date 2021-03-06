package com.appscharles.libs.processer.managers;

import com.appscharles.libs.processer.exceptions.ProcesserException;

/**
 * The interface Kill manager.
 */
public interface IKillManager {

    /**
     * Kill.
     *
     * @param pID the p id
     * @throws ProcesserException the processer exception
     */
    void kill(Long pID) throws ProcesserException;

    /**
     * Kill with child.
     *
     * @param pID the p id
     * @throws ProcesserException the processer exception
     */
    void killWithChild(Long pID) throws ProcesserException;

    /**
     * Kill current.
     *
     * @throws ProcesserException the processer exception
     */
    void killCurrent() throws ProcesserException;

    /**
     * Kill current with child.
     *
     * @throws ProcesserException the processer exception
     */
    void killCurrentWithChild() throws ProcesserException;

    /**
     * Kill start with paths.
     *
     * @param startWithPaths the start with paths
     * @throws ProcesserException the processer exception
     */
    void killStartWithPaths(String startWithPaths) throws ProcesserException;

    /**
     * Kill command line contains.
     *
     * @param content the content
     * @throws ProcesserException the processer exception
     */
    public void killCommandLineContains(String content) throws ProcesserException;
}
