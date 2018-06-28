package com.appscharles.libs.processer.killers;

import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 16:19
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PIDKiller extends AbstractPIDKiller {


    public PIDKiller(ICommanderCaller commanderCaller) {
        super(commanderCaller);
    }

    @Override
    public void kill(Long PID) throws ProcesserException {
        try {
            String cmd = "taskkill /F /PID " + PID;
            this.commanderCaller.call(cmd);
        } catch (ProcesserException e) {
            throw new ProcesserException(e);
        }
    }
}
