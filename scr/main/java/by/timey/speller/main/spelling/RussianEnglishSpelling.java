package by.timey.speller.main.spelling;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.main.util.WordsMapper;

import java.util.*;

public class RussianEnglishSpelling extends AbstractSpelling {

  private static final String MESSAGE = "TRANSLATE FROM RUSSIAN INTO ENGLISH";

  public String getMessage() {
    return MESSAGE;
  }

  protected Map<String, Set<String>> buildWordMap(List<WordTranslation> wordList) {

    Map<String, Set<String>> wordMap = new HashMap<>();
    wordList.forEach(wordTranslation ->
      WordsMapper.putWordPair(
          wordTranslation.getRussianWord(), wordTranslation.getEnglishWord(), wordMap)
    );
    return wordMap;
  }
}
