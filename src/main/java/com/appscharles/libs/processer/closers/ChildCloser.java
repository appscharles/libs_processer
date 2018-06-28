package com.appscharles.libs.processer.closers;

import com.appscharles.libs.processer.exceptions.TaskerException;
import com.appscharles.libs.processer.searchers.IChildSearcher;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 13:44
 * Project name: tasker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ChildCloser extends AbstractChildCloser {

    public ChildCloser(Long parentPID, IChildSearcher childSearcher) {
        super(parentPID, childSearcher);
    }

    public void close()throws TaskerException {
        List<Long> pids = this.childSearcher.search();
    }
}
