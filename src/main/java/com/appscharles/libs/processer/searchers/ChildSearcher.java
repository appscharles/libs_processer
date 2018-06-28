package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.converters.IPIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Child searcher.
 */
public class ChildSearcher extends AbstractChildSearcher {

    /**
     * Instantiates a new Child searcher.
     *
     * @param parentPID       the parent pid
     * @param commanderCaller the commander caller
     * @param iPIDsConverter  the pi ds converter
     */
    public ChildSearcher(Long parentPID, ICommanderCaller commanderCaller, IPIDsConverter iPIDsConverter) {
        super(parentPID, commanderCaller, iPIDsConverter);

    }

    public List<Long> search() throws ProcesserException {
       return getChildPIDs(this.parentPID);
    }

    /**
     * Gets child pi ds.
     *
     * @param parentPID the parent pid
     * @return the child pi ds
     * @throws ProcesserException the processer exception
     */
    private List<Long> getChildPIDs(Long parentPID) throws ProcesserException {
        List<Long> childPIDs = new ArrayList<>();
        CommanderResult result = this.commanderCaller.call("wmic process where parentprocessid=" + parentPID + " get processid /format:csv");
        if (result.isError()){
           return childPIDs;
        } else {
            childPIDs.addAll(this.iPIDsConverter.convert(result.getOutput()));
        }
        List<Long> depthChildPIDs = new ArrayList<>();
        for (Long depthParentPID : childPIDs) {
            depthChildPIDs.addAll(getChildPIDs(depthParentPID));
        }
        childPIDs.addAll(depthChildPIDs);
        return childPIDs;
    }
}
