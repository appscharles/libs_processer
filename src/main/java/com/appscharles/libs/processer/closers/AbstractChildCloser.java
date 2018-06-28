package com.appscharles.libs.processer.closers;

import com.appscharles.libs.processer.killers.IPIDKiller;
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


    protected IChildSearcher childSearcher;

    protected IPIDKiller iPIDKiller;

    public AbstractChildCloser(IChildSearcher childSearcher,IPIDKiller iPIDKiller) {
        this.childSearcher = childSearcher;
        this.iPIDKiller = iPIDKiller;
    }

}
