package com.appscharles.libs.processer.killers;

import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 28.06.2018
 * Time: 16:18
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IPIDsKiller {

    void kill(List<Long> pIDs) throws ProcesserException;
}
