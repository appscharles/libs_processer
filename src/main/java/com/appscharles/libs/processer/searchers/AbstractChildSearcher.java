package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.converters.IPIDsConverter;

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

    protected Long parentPID;

    protected ICommanderCaller commanderCaller;

    protected IPIDsConverter iPIDsConverter;

    public AbstractChildSearcher(Long parentPID, ICommanderCaller commanderCaller, IPIDsConverter iPIDsConverter) {
        this.parentPID = parentPID;
        this.commanderCaller = commanderCaller;
        this.iPIDsConverter = iPIDsConverter;
    }
}
