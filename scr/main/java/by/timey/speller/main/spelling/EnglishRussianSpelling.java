package by.timey.speller.main.spelling;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.main.util.WordsMapper;

import java.util.*;

public class EnglishRussianSpelling extends AbstractSpelling {

  private static final String MESSAGE = "TRANSLATE FROM ENGLISH INTO RUSSIAN";

  public String getMessage() {
    return MESSAGE;
  }

  protected Map<String, Set<String>> buildWordMap(List<WordTranslation> wordList) {

    Map<String, Set<String>> wordMap = new HashMap<>();
    wordList.forEach(wordTranslation -> {

      String englishWord = wordTranslation.getEnglishWord();
      String russianWord = wordTranslation.getRussianWord();

      WordsMapper.putWordPair(englishWord, russianWord, wordMap);
    });
    return wordMap;
  }
}
