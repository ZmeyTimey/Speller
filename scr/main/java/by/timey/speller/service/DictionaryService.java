package by.timey.speller.service;

import by.timey.speller.dao.impl.DictionaryDAO;
import by.timey.speller.model.WordTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryService {

  @Autowired
  private DictionaryDAO dictionaryDAO;

  public void addWordPair(WordTranslation wordTranslation) {
    dictionaryDAO.create(wordTranslation);
  }

  public void addWordPair(String englishWord, String russianWord) {
    WordTranslation wordTranslation = new WordTranslation();

    wordTranslation.setEnglishWord(englishWord);
    wordTranslation.setRussianWord(russianWord);

    dictionaryDAO.create(wordTranslation);
  }

  public List<WordTranslation> getAllWords() {
    return dictionaryDAO.readAll();
  }
  public List<WordTranslation> getWordsWithLimit(int limit) {
    return dictionaryDAO.readWithLimit(limit);
  }
}
