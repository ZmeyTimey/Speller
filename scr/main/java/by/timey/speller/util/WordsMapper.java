package by.timey.speller.util;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordsMapper {

  public static Map<String, Set<String>> putWordPair(String word, String translation,
                                                     Map<String, Set<String>> wordMap) {
    if (wordMap.containsKey(word)) {
      Set<String> translationSet = wordMap.get(word);
      translationSet.add(translation);

    } else {
      Set<String> translationSet = new HashSet<>();
      translationSet.add(translation);
      wordMap.put(word, translationSet);
    }

    return wordMap;
  }
}
