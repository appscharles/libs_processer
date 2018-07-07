package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.converters.PIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 07.07.2018
 * Time: 12:30
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PathSearcherTest {

    @Test
    public void shouldGetPIDs() throws ProcesserException {
        IPathSearcher searcher = new PathSearcher("C:\\Program ", new CommanderCaller(), new PIDsConverter());
        List<Long> pIDs = searcher.search();
        Assert.assertTrue(pIDs.size()>3);
    }

}