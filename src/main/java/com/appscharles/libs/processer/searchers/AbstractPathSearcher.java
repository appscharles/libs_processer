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
public abstract class AbstractPathSearcher implements IPathSearcher {

    protected String executablePath;

    protected ICommanderCaller commanderCaller;

    protected IPIDsConverter iPIDsConverter;

    public AbstractPathSearcher(String executablePath, ICommanderCaller commanderCaller, IPIDsConverter iPIDsConverter) {
        this.executablePath = executablePath;
        this.commanderCaller = commanderCaller;
        this.iPIDsConverter = iPIDsConverter;
    }
}
