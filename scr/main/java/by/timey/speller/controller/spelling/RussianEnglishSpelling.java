package by.timey.speller.controller.spelling;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.util.WordsMapper;

import java.util.*;

import static by.timey.speller.view.MainViewer.print;

public class RussianEnglishSpelling extends AbstractSpelling {

  private static final String MESSAGE = "TRANSLATE FROM RUSSIAN INTO ENGLISH";

  public String getMessage() {
    return MESSAGE;
  }

  protected Map<String, Set<String>> buildWordMap(List<WordTranslation> wordList) {

    Map<String, Set<String>> wordMap = new HashMap<>();
    wordList.forEach(wordTranslation -> {

      String englishWord = wordTranslation.getEnglishWord();
      String russianWord = wordTranslation.getRussianWord();

      WordsMapper.putWordPair(russianWord, englishWord, wordMap);
    });
    return wordMap;
  }
}
