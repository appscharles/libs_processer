package com.appscharles.libs.processer.closers;

import com.appscharles.libs.processer.searchers.IChildSearcher;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 13:53
 * Project name: tasker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractChildCloser implements IChildCloser {

    protected Long parentPID;

    protected IChildSearcher childSearcher;

    public AbstractChildCloser(Long parentPID, IChildSearcher childSearcher) {
        this.parentPID = parentPID;
        this.childSearcher = childSearcher;
    }

}
