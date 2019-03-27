package by.timey.speller.controller;

import by.timey.speller.model.WordTranslation;
import by.timey.speller.service.DictionaryService;
import by.timey.speller.service.UserDictionaryService;
import by.timey.speller.service.UserService;
import by.timey.speller.util.AnswerCounter;
import by.timey.speller.util.ConsoleReader;
import by.timey.speller.view.SpellingTypeDialogViewer;
import by.timey.speller.controller.spelling.Spelling;
import by.timey.speller.controller.spelling.SpellingFactory;

import java.util.List;

import static by.timey.speller.view.MainViewer.*;

/**
 * Speller
 * Creating by Тимей since 24.03.18.
 */
public class Speller {

  private static final UserService USER_SERVICE
      = new UserService();
  private static final DictionaryService DICTIONARY_SERVICE
      = new DictionaryService();
  private static final UserDictionaryService USER_DICTIONARY_SERVICE
      = new UserDictionaryService();


    public static void main(String[] args) {

      ConsoleReader reader = new ConsoleReader();

      cleanScreen();
      printHeader();
      reader.readLine();

      cleanScreen();
      Spelling spelling = initializeSpelling(reader);

      cleanScreen();
      List<WordTranslation> wordTranslationList = DICTIONARY_SERVICE.getAllWords();
      AnswerCounter answerCounter = new AnswerCounter();

      executeSpelling(spelling, wordTranslationList, reader, answerCounter);
      viewResults(answerCounter);
    }

    private static Spelling initializeSpelling(ConsoleReader reader) {

      SpellingTypeDialogViewer spellingTypeDialogViewer = new SpellingTypeDialogViewer(reader);
      spellingTypeDialogViewer.startDialog();
      boolean spellingType = spellingTypeDialogViewer.getSpellingType();

      return new SpellingFactory().buildSpelling(spellingType);
    }

    private static void executeSpelling(Spelling spelling,
                                        List<WordTranslation> wordTranslationList,
                                        ConsoleReader reader,
                                        AnswerCounter answerCounter) {

      print(spelling.getMessage() + "\n");
      spelling.startSpelling(wordTranslationList);

      while (spelling.isInProcess()) {
        spelling.nextWord();

        print(spelling.getCurrentWord());
        String userWord = reader.readLine();

        if (spelling.isUserWordCorrect(userWord)) {
          answerCounter.correct();
          print("Correct!\n");
        } else {
          answerCounter.incorrect();
          print("Incorrect!");
          print("Correct answer: " + spelling.getCurrentTranslation() + "\n");
        }
      }
    }

    private static void viewResults(AnswerCounter answerCounter) {

      int correctAnswers = answerCounter.getCorrectAnswers();
      int incorrectAnswers = answerCounter.getIncorrectAnswers();
      int totalAnswers = correctAnswers + incorrectAnswers;

      print("SPELLING COMPLETE");
      print("Correct answers: " + correctAnswers + "/" + totalAnswers + "\n");

      if (correctAnswers == 0) {
        print("You are stupid asshole!");
      }
      if (incorrectAnswers == 0) {
        print("You are GODLIKE!");
      }
    }
}
