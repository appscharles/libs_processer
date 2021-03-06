package com.appscharles.libs.processer.managers;

import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.closers.ChildCloser;
import com.appscharles.libs.processer.closers.IChildCloser;
import com.appscharles.libs.processer.converters.IPIDsConverter;
import com.appscharles.libs.processer.converters.PIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.processer.extractors.CurrentPIDExtractor;
import com.appscharles.libs.processer.killers.IPIDKiller;
import com.appscharles.libs.processer.killers.IPIDsKiller;
import com.appscharles.libs.processer.killers.PIDKiller;
import com.appscharles.libs.processer.killers.PIDsKiller;
import com.appscharles.libs.processer.searchers.*;

import java.io.File;

/**
 * The type Win kill manager.
 */
public class WinKillManager implements IKillManager {

    private final IPIDKiller _pIDKiller;

    private final IPIDsKiller _pIDsKiller;

    private final ICommanderCaller _commanderCaller;

    private final IPIDsConverter _pIDsConverter;

    /**
     * Instantiates a new Win kill manager.
     */
    public WinKillManager(){
        _pIDsConverter = new PIDsConverter();
        _commanderCaller = new CommanderCaller();
        _pIDKiller = new PIDKiller(_commanderCaller);
        _pIDsKiller = new PIDsKiller(_commanderCaller);
    }

    @Override
    public void kill(Long pID) throws ProcesserException {
        _pIDKiller.kill(pID);
    }

    public void killWithChild(Long pID) throws ProcesserException {
        IChildSearcher childSearcher = new ChildSearcher(pID, _commanderCaller, _pIDsConverter);
        IChildCloser childCloser = new ChildCloser(childSearcher, _pIDKiller);
        childCloser.close();
        _pIDKiller.kill(pID);
    }

    public void killCurrent() throws ProcesserException {
        _pIDKiller.kill(CurrentPIDExtractor.extract());
    }

    public void killCurrentWithChild() throws ProcesserException {
        IChildSearcher childSearcher = new ChildSearcher(CurrentPIDExtractor.extract(), _commanderCaller, _pIDsConverter);
        IChildCloser childCloser = new ChildCloser(childSearcher, _pIDKiller);
        childCloser.close();
        _pIDKiller.kill(CurrentPIDExtractor.extract());
    }

    @Override
    public void killStartWithPaths(String startWithPaths) throws ProcesserException {
        IPathSearcher searcher = new PathSearcher(new File(startWithPaths).getAbsolutePath(), _commanderCaller, _pIDsConverter);
        _pIDsKiller.kill(searcher.search());
    }

    @Override
    public void killCommandLineContains(String content) throws ProcesserException {
        ICommandLineSearcher searcher = new CommandLineSearcher(content, _commanderCaller, _pIDsConverter);
        _pIDsKiller.kill(searcher.search());
    }
}
