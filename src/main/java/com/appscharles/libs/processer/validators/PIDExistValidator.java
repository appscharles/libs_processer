package com.appscharles.libs.processer.validators;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.converters.IPIDsConverter;
import com.appscharles.libs.processer.converters.PIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;

/**
 * The type Pid validator.
 */
public class PIDExistValidator {

    /**
     * Exist boolean.
     *
     * @param pID the p id
     * @return the boolean
     * @throws ProcesserException the processer exception
     */
    public static Boolean isValid(Long pID) throws ProcesserException {
        IPIDsConverter iPIDsConverter = new PIDsConverter();
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("wmic process where processid=" + pID + " get processid /format:csv");
        if (result.isError()){
            return false;
        } else {
            return iPIDsConverter.convert(result.getOutput()).size() > 0;
        }
    }
}
