package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Utils class</h1>
 * The Utils class implements methods for general
 * purposes
 *
 * @author  Juan Escamilla
 * @version 1.0
 * @since   2024-12-01
 */

public class Utils {

    /**
     * This method is used to read an input file
     * line by line and save it as a List
     * @param path This is the absolute path
     *             of the file
     * @return List which contains each line
     * of the file as a String
     * @exception IOException On input error.
     * @see IOException
     */
    public static List<String> readInputLineByLine(String path) throws IOException {
        File file = new File(path);
        List<String> result = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                result.add(st);
            }
        return result;
    }
}
