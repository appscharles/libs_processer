package com.appscharles.libs.processer.validators;

import com.appscharles.libs.processer.exceptions.ProcesserException;
import org.junit.Assert;
import org.junit.Test;
import org.jvnet.winp.WinProcess;

import java.io.IOException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 02.07.2018
 * Time: 22:58
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PIDExistValidatorTest {

    @Test
    public void shouldExistPID() throws IOException, ProcesserException {
        Process process = Runtime.getRuntime().exec("notepad.exe");
        WinProcess wp = new WinProcess(process);
        Assert.assertTrue(PIDExistValidator.isValid(new Long(wp.getPid())));
        process.destroyForcibly();
        Assert.assertFalse(PIDExistValidator.isValid(new Long(wp.getPid())));
    }
}