package model;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by Тимон on 30.03.18.
 *
 */
 public class PathFinder {
    public static String getClassDirectory() throws Exception {
        URL resource = new PathFinder().getClass().getResource("/");
        String classDirectory = resource.getFile();
        return classDirectory;
    }
}
