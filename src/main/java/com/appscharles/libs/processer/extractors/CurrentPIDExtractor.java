package com.appscharles.libs.processer.extractors;

import java.lang.management.ManagementFactory;

/**
 * The type Current pid extractor.
 */
public class CurrentPIDExtractor {

    /**
     * Extract long.
     *
     * @return the long
     */
    public static Long extract(){
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        return new Long(jvmName.split("@")[0]);
    }
}
