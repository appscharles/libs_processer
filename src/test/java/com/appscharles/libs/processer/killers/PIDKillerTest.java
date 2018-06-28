package com.appscharles.libs.processer.killers;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.converters.PIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.processer.extractors.CurrentPIDExtractor;
import com.appscharles.libs.processer.searchers.ChildSearcher;
import com.appscharles.libs.processer.searchers.IChildSearcher;
import org.junit.Assert;
import org.junit.Test;
import org.jvnet.winp.WinProcess;

import java.io.IOException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 16:22
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PIDKillerTest {

    @Test
    public void shouldKillProcess() throws IOException, ProcesserException {
        Process process = Runtime.getRuntime().exec("notepad.exe");
        WinProcess wp = new WinProcess(process);
        IChildSearcher iChildSearcher = new ChildSearcher(CurrentPIDExtractor.extract(), new CommanderCaller(), new PIDsConverter());
        Assert.assertEquals(iChildSearcher.search().size(), 3);
        IPIDKiller ipidKiller = new PIDKiller(new CommanderCaller());
        ipidKiller.kill(new Long(wp.getPid()));
        Assert.assertEquals(iChildSearcher.search().size(), 2);
        process.destroyForcibly();
    }

}