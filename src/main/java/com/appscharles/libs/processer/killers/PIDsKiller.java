package com.appscharles.libs.processer.killers;

import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 16:19
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PIDsKiller extends AbstractPIDsKiller {


    public PIDsKiller(ICommanderCaller commanderCaller) {
        super(commanderCaller);
    }

    @Override
    public void kill(List<Long> pIDs) throws ProcesserException {
        try {
            for (Long pID : pIDs) {
                String cmd = "taskkill /F /PID " + pID;
                this.commanderCaller.call(cmd);
            }
        } catch (ProcesserException e) {
            throw new ProcesserException(e);
        }
    }
}
