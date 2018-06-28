package com.appscharles.libs.processer.searchers;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 13:54
 * Project name: tasker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractChildSearcher implements IChildSearcher {

    protected Integer parentPID;

    public AbstractChildSearcher(Integer parentPID) {
        this.parentPID = parentPID;
    }
}
