package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.processer.exceptions.TaskerException;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 13:48
 * Project name: tasker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ChildSearcher extends AbstractChildSearcher {

    public ChildSearcher(Integer parentPID) {
        super(parentPID);
    }

    public List<Long> search() throws TaskerException {
        return null;
    }
}
