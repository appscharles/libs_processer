package com.appscharles.libs.processer.callers;

import com.appscharles.libs.processer.exceptions.ProcesserException;
import org.junit.Assert;
import org.junit.Test;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 14:47
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class CommanderCallerTest {

    @Test
    public void shouldCommandResultNotEmpty() throws ProcesserException {
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("wmic process get processid");
        Assert.assertFalse(result.getOutput().isEmpty());
    }

    @Test(expected = ProcesserException.class)
    public void shouldThrowProcesserException() throws ProcesserException {
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("wmice process get processid");
    }

    @Test
    public void shouldCommanderHasError() throws ProcesserException {
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("wmic process where processid=233455 get processid");
        Assert.assertTrue(result.isError());
    }
}