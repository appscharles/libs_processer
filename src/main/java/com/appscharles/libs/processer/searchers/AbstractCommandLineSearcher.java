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
public abstract class AbstractCommandLineSearcher implements ICommandLineSearcher {

    protected String content;

    protected ICommanderCaller commanderCaller;

    protected IPIDsConverter iPIDsConverter;

    public AbstractCommandLineSearcher(String content, ICommanderCaller commanderCaller, IPIDsConverter iPIDsConverter) {
        this.content = content;
        this.commanderCaller = commanderCaller;
        this.iPIDsConverter = iPIDsConverter;
    }
}
