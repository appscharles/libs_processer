package com.appscharles.libs.processer.converters;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 15:26
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PIDsConverterTest {

    @Test
    public void shouldConvertMinOnePID() throws ProcesserException {
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("wmic process get processid /format:csv");
        IPIDsConverter converter = new PIDsConverter();
        List<Long> pIDs = converter.convert(result.getOutput());
        Assert.assertTrue(pIDs.size()>0);
    }
}