package by.timey.speller.main.spelling;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.main.util.WordsMapper;

import java.util.*;

import static by.timey.speller.view.ViewConstantStore.MESSAGE_TRANSLATE_ENGLISH;

public class EnglishRussianSpelling extends AbstractSpelling {

  private static final String MESSAGE = MESSAGE_TRANSLATE_ENGLISH;

  EnglishRussianSpelling(List<WordTranslation> wordList, int wordsNumber) {
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

        String englishWord = wordTranslation.getEnglishWord();
        String russianWord = wordTranslation.getRussianWord();

        WordsMapper.putWordPair(englishWord, russianWord, wordMap);
      }
    } else {
      wordList.forEach(wordTranslation ->
        WordsMapper.putWordPair(wordTranslation.getRussianWord(),
            wordTranslation.getEnglishWord(), wordMap));
    }
    return wordMap;
  }
}
