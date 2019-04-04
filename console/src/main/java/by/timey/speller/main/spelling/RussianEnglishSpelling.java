package by.timey.speller.main.spelling;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.main.util.WordsMapper;

import java.util.*;

public class RussianEnglishSpelling extends AbstractSpelling {

  private static final String MESSAGE = "TRANSLATE FROM RUSSIAN INTO ENGLISH";

  RussianEnglishSpelling(List<WordTranslation> wordList, int wordsNumber) {
    super(wordList, wordsNumber);
  }

  public String getMessage() {
    return MESSAGE;
  }

  protected Map<String, Set<String>> buildWordMap() {

    Map<String, Set<String>> wordMap = new HashMap<>();

    if (wordsNumber != 0) {
      Iterator<WordTranslation> iterator = wordList.iterator();
      while (wordMap.size() < wordsNumber) {
        WordTranslation wordTranslation = iterator.next();

        WordsMapper.putWordPair(wordTranslation.getRussianWord(),
            wordTranslation.getEnglishWord(), wordMap);
      }

    } else {
      wordList.forEach(wordTranslation ->
        WordsMapper.putWordPair(wordTranslation.getRussianWord(),
            wordTranslation.getEnglishWord(), wordMap));
    }
    return wordMap;
  }
}
