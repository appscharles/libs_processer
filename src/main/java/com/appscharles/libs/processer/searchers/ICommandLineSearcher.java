package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 13:50
 * Project name: tasker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface ICommandLineSearcher {

    List<Long> search() throws ProcesserException;
}
