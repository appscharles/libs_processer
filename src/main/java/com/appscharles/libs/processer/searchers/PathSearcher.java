package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.converters.IPIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Path searcher.
 */
public class PathSearcher extends AbstractPathSearcher {

    /**
     * Instantiates a new Path searcher.
     *
     * @param executablePath  the executable path
     * @param commanderCaller the commander caller
     * @param iPIDsConverter  the pi ds converter
     */
    public PathSearcher(String executablePath, ICommanderCaller commanderCaller, IPIDsConverter iPIDsConverter) {
        super(executablePath, commanderCaller, iPIDsConverter);

    }

    public List<Long> search() throws ProcesserException {
        List<Long> pIDs = new ArrayList<>();
        CommanderResult result = this.commanderCaller.call("wmic process where \"ExecutablePath like '"+this.executablePath.replace("\\", "\\\\")+"%'\" get processid /format:csv");
        if (result.isError()){
            return pIDs;
        } else {
            pIDs.addAll(this.iPIDsConverter.convert(result.getOutput()));
            return pIDs;
        }
    }
}
