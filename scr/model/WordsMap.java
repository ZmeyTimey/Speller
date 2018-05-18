package model;

/**
 * Created by Тимей on 18.05.2018.
 *
 */
public class WordsMap {

    String key;
    String value[];
    boolean kindOfMap;

    public WordsMap(boolean kindOfMap) {
        this.kindOfMap = kindOfMap;
    }

    public String getKey() {
        return key;
    }

    public String[] getValue() {
        return value;
    }

    public void createMap(String str) {
        String parts[] = str.split("-");
        String foreignWord = parts[0];
        String translations[] = parts[1].split(", ");

        if (kindOfMap) {
            key = translations[0];
            value[0] = foreignWord;
        } else {
            key = foreignWord;
            value = translations;
        }
    }

}
