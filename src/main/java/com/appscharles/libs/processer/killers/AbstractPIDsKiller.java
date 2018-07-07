package com.appscharles.libs.processer.killers;

import com.appscharles.libs.processer.callers.ICommanderCaller;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 16:21
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractPIDsKiller implements IPIDsKiller {

    protected ICommanderCaller commanderCaller;

    public AbstractPIDsKiller(ICommanderCaller commanderCaller) {
        this.commanderCaller = commanderCaller;
    }
}
