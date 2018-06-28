package com.appscharles.libs.processer.callers;

import com.appscharles.libs.processer.converters.BufferedReaderConvert;
import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 14:14
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class CommanderCaller implements ICommanderCaller{

    public CommanderResult call(String command) throws ProcesserException {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bRInput = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            BufferedReader bRError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
            String input = BufferedReaderConvert.convert(bRInput);
            String error = BufferedReaderConvert.convert(bRError);
            if (error.isEmpty() == false){
                return new CommanderResult(true, error);
            } else {
                return new CommanderResult(false, input);
            }
        } catch (IOException e) {
            throw new ProcesserException(e);
        }
    }
}
