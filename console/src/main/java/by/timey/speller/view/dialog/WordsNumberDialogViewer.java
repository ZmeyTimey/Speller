package by.timey.speller.view.dialog;

import by.timey.speller.main.util.ConsoleReader;
import lombok.Getter;

import static by.timey.speller.view.MainConsoleViewer.cleanScreen;
import static by.timey.speller.view.MainConsoleViewer.print;
import static by.timey.speller.view.ViewConstantStore.*;

public class WordsNumberDialogViewer implements DialogViewer {

  private ConsoleReader reader;

  @Getter
  private Integer wordsNumber;

  public WordsNumberDialogViewer(ConsoleReader reader) {
    this.reader = reader;
  }

  private void printDialogMessage() {
    print(DIALOG_WORDS_NUMBER_MESSAGE);
  }

  @Override
  public void startDialog() {
    printDialogMessage();

    while (true) {

      String inputNumber = reader.readLine();

      try {
        wordsNumber = Integer.parseInt(inputNumber);
      } catch (NumberFormatException e) {
        wordsNumber = null;
      }

      if (wordsNumber != null) {
        break;
      } else {
        cleanScreen();
        print(DIALOG_WORDS_NUMBER_ERROR);
        print(DIALOG_WORDS_NUMBER_TRY_AGAIN);
      }
    }
  }
}
