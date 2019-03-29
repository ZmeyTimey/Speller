package by.timey.speller.view.dialog;

import by.timey.speller.main.util.ConsoleReader;
import lombok.Getter;

import static by.timey.speller.view.MainConsoleViewer.cleanScreen;
import static by.timey.speller.view.MainConsoleViewer.print;

public class WordsNumberDialogViewer implements DialogViewer {

  private ConsoleReader reader;

  @Getter
  private Integer wordsNumber;

  public WordsNumberDialogViewer(ConsoleReader reader) {
    this.reader = reader;
  }

  private void printDialogMessage() {
    print("Choose the number of words");
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
        print("A bullshit you entered is not a number or something else went wrong");
        print("Please, try again, darling...");
      }
    }
  }
}
