package by.timey.speller.controller.spelling;

import by.timey.speller.model.WordTranslation;

import java.util.List;
import java.util.Set;

public interface Spelling {

  String getMessage();
  boolean isInProcess();
  void startSpelling(List<WordTranslation> wordList);
  void nextWord();
  String getCurrentWord();
  Set<String> getCurrentTranslation();
  boolean isUserWordCorrect(String userWord);
}
