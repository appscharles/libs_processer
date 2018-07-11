package com.appscharles.libs.processer.searchers;

import com.appscharles.libs.jarer.builders.ManifestBuilder;
import com.appscharles.libs.jarer.creators.JarCreator;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.converters.PIDsConverter;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import com.appscharles.libs.processer.killers.PIDsKiller;
import com.appscharles.libs.processer.programs.tester.Tester;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.jar.Manifest;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 11.07.2018
 * Time: 16:02
 * Project name: processer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class CommandLineSearcherTest {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Test
    public void shouldFoundPIDs() throws ProcesserException, IOException, InterruptedException, JarerException {
        File jarFile = new File(this.temp.newFolder(), "file.jar");
        Manifest manifest = ManifestBuilder.create("myApp", "1.0.0.0-dev2", Tester.class).build();
        JarCreator jarCreator = new JarCreator(jarFile, manifest, Tester.class.getProtectionDomain().getCodeSource().getLocation());
        jarCreator.addPackage(Tester.class.getPackage().getName());
        jarCreator.create();
        Runtime.getRuntime().exec("java -jar " + jarFile.getPath() + " --testCommandLine");
        Thread.sleep(1000);
        ICommandLineSearcher searcher = new CommandLineSearcher(jarFile.getAbsolutePath().replace("\\", "\\\\"), new CommanderCaller(), new PIDsConverter());
        List<Long> pIDs = searcher.search();
        new PIDsKiller(new CommanderCaller()).kill(pIDs);
    }
}