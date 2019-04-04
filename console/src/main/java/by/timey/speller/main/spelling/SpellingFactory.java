package by.timey.speller.main.spelling;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.service.DictionaryService;

import java.util.Collections;
import java.util.List;

public class SpellingFactory {

  public Spelling buildSpelling(boolean spellingType, int wordsNumber, DictionaryService service) {

    List<WordTranslation> wordTranslationList = service.getAllWords();
    Collections.shuffle(wordTranslationList);

    if (spellingType) {
      return new RussianEnglishSpelling(wordTranslationList, wordsNumber);
    } else {
      return new EnglishRussianSpelling(wordTranslationList, wordsNumber);
    }
  }
}
