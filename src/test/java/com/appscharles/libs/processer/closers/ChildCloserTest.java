package com.appscharles.libs.processer.closers;

import com.appscharles.libs.processer.builders.ChildCloserBuilder;
import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.converters.PIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.processer.extractors.CurrentPIDExtractor;
import com.appscharles.libs.processer.killers.PIDKiller;
import com.appscharles.libs.processer.searchers.ChildSearcher;
import com.appscharles.libs.processer.searchers.IChildSearcher;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 16:39
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ChildCloserTest {

    @Test
    public void shouldClosedAllChildPIDs() throws IOException, ProcesserException {
        Runtime.getRuntime().exec("notepad.exe");
        Runtime.getRuntime().exec("notepad.exe");
        ICommanderCaller commanderCaller = new CommanderCaller();
        IChildSearcher iChildSearcher = new ChildSearcher(CurrentPIDExtractor.extract(), commanderCaller, new PIDsConverter());
        Assert.assertEquals(iChildSearcher.search().size(), 4);
        IChildCloser childCloser = new ChildCloser(iChildSearcher, new PIDKiller(commanderCaller));
        childCloser.close();
        Assert.assertEquals(iChildSearcher.search().size(), 1);
    }

    @Test
    public void shouldClosedAllChildPIDsByBuilder() throws IOException, ProcesserException {
        Runtime.getRuntime().exec("notepad.exe");
        Runtime.getRuntime().exec("notepad.exe");
        IChildCloser childCloser = ChildCloserBuilder.create().build();
        childCloser.close();
        ICommanderCaller commanderCaller = new CommanderCaller();
        IChildSearcher iChildSearcher = new ChildSearcher(CurrentPIDExtractor.extract(), commanderCaller, new PIDsConverter());
        Assert.assertEquals(iChildSearcher.search().size(), 1);
    }
}