package by.timey.speller.main;

import by.timey.speller.main.config.SpringMainConfig;
import by.timey.speller.model.WordTranslation;
import by.timey.speller.service.DictionaryService;
import by.timey.speller.main.util.AnswerCounter;
import by.timey.speller.main.util.ConsoleReader;
import by.timey.speller.view.SpellingTypeDialogViewer;
import by.timey.speller.main.spelling.Spelling;
import by.timey.speller.main.spelling.SpellingFactory;
import by.timey.speller.view.StartDialogViewer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
      context.register(SpringMainConfig.class);
      context.refresh();

      cleanScreen();
      printHeader();

      Speller speller = context.getBean(Speller.class);
      speller.start();
    }

    private void start() {

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
      List<WordTranslation> wordTranslationList = dictionaryService.getAllWords();
      AnswerCounter answerCounter = new AnswerCounter();

      executeSpelling(spelling, wordTranslationList, answerCounter);
      viewResults(answerCounter);

      reader.readLine();
      start();
    }

    private Spelling initializeSpelling() {

      SpellingTypeDialogViewer spellingTypeDialogViewer = new SpellingTypeDialogViewer(reader);
      spellingTypeDialogViewer.startDialog();
      boolean spellingType = spellingTypeDialogViewer.getSpellingType();

      return new SpellingFactory().buildSpelling(spellingType);
    }

    private void executeSpelling(Spelling spelling,
                                 List<WordTranslation> wordTranslationList,
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
