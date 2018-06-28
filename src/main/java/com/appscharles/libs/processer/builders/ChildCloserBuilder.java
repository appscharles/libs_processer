package com.appscharles.libs.processer.builders;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.closers.ChildCloser;
import com.appscharles.libs.processer.closers.IChildCloser;
import com.appscharles.libs.processer.converters.IPIDsConverter;
import com.appscharles.libs.processer.converters.PIDsConverter;
import com.appscharles.libs.processer.extractors.CurrentPIDExtractor;
import com.appscharles.libs.processer.killers.IPIDKiller;
import com.appscharles.libs.processer.killers.PIDKiller;
import com.appscharles.libs.processer.searchers.ChildSearcher;
import com.appscharles.libs.processer.searchers.IChildSearcher;

/**
 * The type Child closer builder.
 */
public class ChildCloserBuilder {

    private ICommanderCaller commanderCaller;

    private Long parentPID;

    private IPIDsConverter pIDsConverter;

    private IChildSearcher childSearcher;

    private IChildCloser childCloser;

    private IPIDKiller pIDKiller;

    private ChildCloserBuilder(){

    }

    /**
     * Create child closer builder.
     *
     * @return the child closer builder
     */
    public static ChildCloserBuilder create(){
        ChildCloserBuilder instance = new ChildCloserBuilder();
        instance.commanderCaller = new CommanderCaller();
        instance.parentPID = CurrentPIDExtractor.extract();
        instance.pIDsConverter = new PIDsConverter();
        instance.childSearcher = new ChildSearcher(instance.parentPID, instance.commanderCaller, instance.pIDsConverter);
        instance.pIDKiller = new PIDKiller(instance.commanderCaller);
        instance.childCloser = new ChildCloser(instance.childSearcher, instance.pIDKiller);
        return instance;
    }

    /**
     * Build child closer.
     *
     * @return the child closer
     */
    public IChildCloser build() {
        return this.childCloser;
    }

    /**
     * Commander caller.
     *
     * @param commanderCaller the commander caller
     */
    public void commanderCaller(ICommanderCaller commanderCaller) {
        this.commanderCaller = commanderCaller;
    }

    /**
     * P i ds converter.
     *
     * @param pIDsConverter the p i ds converter
     */
    public void pIDsConverter(IPIDsConverter pIDsConverter) {
        this.pIDsConverter = pIDsConverter;
    }

    /**
     * Child searcher.
     *
     * @param childSearcher the child searcher
     */
    public void childSearcher(IChildSearcher childSearcher) {
        this.childSearcher = childSearcher;
    }

    /**
     * Child closer.
     *
     * @param childCloser the child closer
     */
    public void childCloser(IChildCloser childCloser) {
        this.childCloser = childCloser;
    }

    /**
     * P id killer.
     *
     * @param pIDKiller the p id killer
     */
    public void pIDKiller(IPIDKiller pIDKiller) {
        this.pIDKiller = pIDKiller;
    }
}
