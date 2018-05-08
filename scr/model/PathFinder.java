package model;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Тимон on 30.03.18.
 *
 */
 public class PathFinder {
    public static String getClassDirectory() throws Exception {

        return System.getProperty("user.dir");
    }
}
