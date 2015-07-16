package org.codecop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Little helper to write a String to a File and read it again.
 */
public class StringToFile {

    public static void write(String text, File file) throws IOException {
        FileWriter out = new FileWriter(file);
        try {
            out.write(text);
            out.flush();
        } finally {
            out.close();
        }
    }

    public static String read(File file) throws IOException {
        FileReader in = new FileReader(file);
        try {
            char[] buffer = new char[(int) file.length()];
            in.read(buffer);
            return new String(buffer);
        } finally {
            in.close();
        }
    }

}
