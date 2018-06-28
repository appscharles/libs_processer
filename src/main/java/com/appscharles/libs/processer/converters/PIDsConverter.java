package com.appscharles.libs.processer.converters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Pi ds converter.
 */
public class PIDsConverter implements IPIDsConverter {

    @Override
    public List<Long> convert(Object object) {
        List<Long> pIDs = new ArrayList<>();
        List<String> lines = new ArrayList<>(Arrays.asList(object.toString().split(System.getProperty("line.separator"))));
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()){
                continue;
            }
            String processID = line.split(",")[1];
            if (processID.matches("\\d*")){
                pIDs.add(new Long(processID));
            }
        }
        return pIDs;
    }
}
