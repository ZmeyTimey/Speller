package by.timey.speller.main.spelling;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.service.DictionaryService;

import java.util.List;

public class SpellingFactory {

  public Spelling buildSpelling(boolean spellingType, int wordsNumber, DictionaryService service) {

    List<WordTranslation> wordTranslationList = service.getWordsWithLimit(wordsNumber);

    if (spellingType) {
      return new RussianEnglishSpelling(wordTranslationList);
    } else {
      return new EnglishRussianSpelling(wordTranslationList);
    }
  }
}
