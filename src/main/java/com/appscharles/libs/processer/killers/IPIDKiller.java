package com.appscharles.libs.processer.killers;

import com.appscharles.libs.processer.exceptions.ProcesserException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 16:18
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IPIDKiller {

    void kill(Long PID) throws ProcesserException;
}
