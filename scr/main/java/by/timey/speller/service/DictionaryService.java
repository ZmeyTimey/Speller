package by.timey.speller.service;

import by.timey.speller.dao.impl.DictionaryDAO;
import by.timey.speller.model.WordTranslation;

import java.util.List;

public class DictionaryService {

  private static final DictionaryDAO DICTIONARY_DAO
      = new DictionaryDAO();

  public void addWordPair(WordTranslation wordTranslation) {
    DICTIONARY_DAO.create(wordTranslation);
  }

  public void addWordPair(String englishWord, String russianWord) {
    WordTranslation wordTranslation = new WordTranslation();

    wordTranslation.setEnglishWord(englishWord);
    wordTranslation.setRussianWord(russianWord);

    DICTIONARY_DAO.create(wordTranslation);
  }

  public List<WordTranslation> getAllWords() {
    return DICTIONARY_DAO.readAll();
  }
}
