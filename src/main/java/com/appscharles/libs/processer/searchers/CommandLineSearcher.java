package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.converters.IPIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Command line searcher.
 */
public class CommandLineSearcher extends AbstractCommandLineSearcher {

    /**
     * Instantiates a new Command line searcher.
     *
     * @param content         the content
     * @param commanderCaller the commander caller
     * @param iPIDsConverter  the pi ds converter
     */
    public CommandLineSearcher(String content, ICommanderCaller commanderCaller, IPIDsConverter iPIDsConverter) {
        super(content, commanderCaller, iPIDsConverter);

    }

    public List<Long> search() throws ProcesserException {
        List<Long> pIDs = new ArrayList<>();
        CommanderResult result = this.commanderCaller.call("wmic process where \"CommandLine like '%"+this.content+"%'\" get processid /format:csv");
        if (result.isError()){
            return pIDs;
        } else {
            pIDs.addAll(this.iPIDsConverter.convert(result.getOutput()));
            return pIDs;
        }
    }
}
