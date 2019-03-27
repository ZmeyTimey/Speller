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
import by.timey.speller.view.StartDialogViewer;

import java.util.List;

import static by.timey.speller.view.MainConsoleViewer.*;
import static java.lang.Thread.sleep;

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

  private static ConsoleReader reader = new ConsoleReader();

    public static void main(String[] args) {

      cleanScreen();
      printHeader();

      reader.readLine();
      start(reader);
    }

    private static void start(ConsoleReader reader) {
      StartDialogViewer dialogViewer = new StartDialogViewer(reader);
      dialogViewer.startDialog();
      if (dialogViewer.getContinueOrExit()) {
        spell();
      } else {
        exit();
      }
    }

    private static void spell() {
      cleanScreen();
      Spelling spelling = initializeSpelling(reader);

      cleanScreen();
      List<WordTranslation> wordTranslationList = DICTIONARY_SERVICE.getAllWords();
      AnswerCounter answerCounter = new AnswerCounter();

      executeSpelling(spelling, wordTranslationList, reader, answerCounter);
      viewResults(answerCounter);

      reader.readLine();
      start(reader);
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

        printWithColon(spelling.getCurrentWord());
        String userWord = reader.readLine();

        if (spelling.isUserWordCorrect(userWord)) {
          answerCounter.correct();
          printMsgCorrect();

        } else {
          answerCounter.incorrect();
          printMsgIncorrect(spelling.getCurrentTranslation());
        }
      }
    }

    private static void viewResults(AnswerCounter answerCounter) {

      int correctAnswers = answerCounter.getCorrectAnswers();
      int incorrectAnswers = answerCounter.getIncorrectAnswers();
      int totalAnswers = correctAnswers + incorrectAnswers;

      printSpellingCompleteMsg();
      printSpellingResults(correctAnswers, incorrectAnswers, totalAnswers);
    }

    private static void exit() {
      cleanScreen();
      printGoodbye();

      try {
        sleep(5000);
      } catch (InterruptedException e) {
        cleanScreen();
      }
    }
}
