package by.timey.speller.main.spelling;

public class SpellingFactory {

  public Spelling buildSpelling(boolean spellingType, int wordsNumber) {

    if (spellingType) {
      return new RussianEnglishSpelling(wordsNumber);
    } else {
      return new EnglishRussianSpelling(wordsNumber);
    }
  }
}
