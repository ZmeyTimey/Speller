package by.timey.speller.controller.spelling;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.util.Checker;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractSpelling implements Spelling {

  private boolean inProcess;
  private Iterator<Map.Entry<String, Set<String>>> iterator;
  private Map.Entry<String, Set<String>> currentEntry;

  @Override
  public boolean isInProcess() {
    return inProcess;
  }

  @Override
  public String getCurrentWord() {
    return currentEntry.getKey();
  }

  @Override
  public Set<String> getCurrentTranslation() {
    return currentEntry.getValue();
  }

  @Override
  public abstract String getMessage();

  @Override
  public void startSpelling(List<WordTranslation> wordList) {

    Map<String, Set<String>> wordMap = buildWordMap(wordList);
    iterator = wordMap.entrySet().iterator();
    inProcess = true;
  }

  @Override
  public void nextWord() {
    currentEntry = iterator.next();
    if (!iterator.hasNext()) {
      inProcess = false;
    }
  }

  @Override
  public boolean isUserWordCorrect(String userWord) {
    return Checker.check(userWord, currentEntry.getValue());
  }

  protected abstract Map<String, Set<String>> buildWordMap(List<WordTranslation> wordTranslationList);
}
