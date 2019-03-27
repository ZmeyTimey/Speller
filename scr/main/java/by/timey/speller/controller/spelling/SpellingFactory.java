package by.timey.speller.controller.spelling;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpellingFactory {

  public Spelling buildSpelling(boolean spellingType) {

    if (spellingType) {
      return new RussianEnglishSpelling();
    } else {
      return new EnglishRussianSpelling();
    }
  }
}
