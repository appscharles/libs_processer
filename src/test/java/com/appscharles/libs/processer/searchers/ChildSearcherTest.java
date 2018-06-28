package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.converters.PIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.processer.extractors.CurrentPIDExtractor;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 15:48
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ChildSearcherTest {

    @Test
    public void shouldFoundTwoPIDs() throws ProcesserException, IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("notepad.exe");
        IChildSearcher iChildSearcher = new ChildSearcher(CurrentPIDExtractor.extract(), new CommanderCaller(), new PIDsConverter());
        Assert.assertEquals(iChildSearcher.search().size(), 3);
        process.destroyForcibly();
    }
}