package com.appscharles.libs.processer.converters;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The type Buffered reader convert.
 */
public class BufferedReaderConvert {

    /**
     * Convert string.
     *
     * @param bufferedReader the buffered reader
     * @return the string
     * @throws IOException the io exception
     */
    public static String convert(BufferedReader bufferedReader) throws IOException {
        StringBuilder sB = new StringBuilder();
        String line = bufferedReader.readLine();
        if (line != null){
            sB.append(line);
            while ((line = bufferedReader.readLine()) != null) {
               sB.append(System.getProperty("line.separator"));
                sB.append(line);
            }
        }
        return sB.toString();
    }
}
