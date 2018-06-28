package com.appscharles.libs.processer.closers;

import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.processer.killers.IPIDKiller;
import com.appscharles.libs.processer.searchers.IChildSearcher;

import java.util.List;

/**
 * The type Child closer.
 */
public class ChildCloser extends AbstractChildCloser {

    /**
     * Instantiates a new Child closer.
     *
     * @param childSearcher the child searcher
     * @param iPIDKiller    the pid killer
     */
    public ChildCloser(IChildSearcher childSearcher, IPIDKiller iPIDKiller) {
        super(childSearcher, iPIDKiller);
    }

    public void close()throws ProcesserException {
        List<Long> pIDs = this.childSearcher.search();
        for (Long pID : pIDs) {
            this.iPIDKiller.kill(pID);
        }
    }
}
