package by.timey.speller.main;

import by.timey.speller.service.DictionaryService;
import by.timey.speller.main.util.AnswerCounter;
import by.timey.speller.main.util.ConsoleReader;
import by.timey.speller.view.dialog.SpellingTypeDialogViewer;
import by.timey.speller.main.spelling.Spelling;
import by.timey.speller.main.spelling.SpellingFactory;
import by.timey.speller.view.dialog.StartDialogViewer;
import by.timey.speller.view.dialog.WordsNumberDialogViewer;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static by.timey.speller.view.MainConsoleViewer.*;
import static java.lang.Thread.sleep;

/**
 * Speller
 * Creating by Тимей since 24.03.18.
 */
@Getter
@Component
public class Speller {

  private DictionaryService dictionaryService;
  private ConsoleReader reader;

  @Autowired
  private void setDictionaryService(DictionaryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  @Autowired
  private void setReader(ConsoleReader reader) {
    this.reader = reader;
  }

    void start() {

    cleanScreen();
    printHeader();
    reader.readLine();

    StartDialogViewer dialogViewer = new StartDialogViewer(reader);
    dialogViewer.startDialog();

      if (dialogViewer.getContinueOrExit()) {
        spell();
      } else {
        exit();
      }
    }

    private void spell() {
      cleanScreen();
      Spelling spelling = initializeSpelling();

      cleanScreen();
      AnswerCounter answerCounter = new AnswerCounter();

      executeSpelling(spelling, answerCounter);
      viewResults(answerCounter);

      reader.readLine();
      start();
    }

    private Spelling initializeSpelling() {

      SpellingTypeDialogViewer spellingTypeDialogViewer
          = new SpellingTypeDialogViewer(reader);
      spellingTypeDialogViewer.startDialog();
      boolean spellingType = spellingTypeDialogViewer.getSpellingType();

      WordsNumberDialogViewer wordsNumberDialogViewer
          = new WordsNumberDialogViewer(reader);
      wordsNumberDialogViewer.startDialog();
      int wordsNumber = wordsNumberDialogViewer.getWordsNumber();

      return new SpellingFactory().buildSpelling(spellingType, wordsNumber, dictionaryService);
    }

    private void executeSpelling(Spelling spelling,
                                 AnswerCounter answerCounter) {

      print(spelling.getMessage() + "\n");
      spelling.startSpelling();

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

    private void viewResults(AnswerCounter answerCounter) {

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
