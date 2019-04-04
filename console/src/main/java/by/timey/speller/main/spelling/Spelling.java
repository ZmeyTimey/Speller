package by.timey.speller.main.spelling;

import java.util.Set;

public interface Spelling {

  String getMessage();
  boolean isInProcess();
  void startSpelling();
  void nextWord();
  String getCurrentWord();
  Set<String> getCurrentTranslation();
  boolean isUserWordCorrect(String userWord);
}
