package by.timey.speller.view;

import by.timey.speller.util.ConsoleReader;
import lombok.Getter;

import static by.timey.speller.view.MainConsoleViewer.cleanScreen;
import static by.timey.speller.view.MainConsoleViewer.print;

public class SpellingTypeDialogViewer {

  private ConsoleReader reader;

  @Getter
  private Boolean spellingType;

  public SpellingTypeDialogViewer(ConsoleReader reader) {
    this.reader = reader;
  }

  private void printSpellingChoiceMsg() {
    print("Choose spelling type:");
  }
  private void printNumCases() {
    print("English to Russian - 0, Russian to English - 1");
  }

  public void startDialog() {
    printSpellingChoiceMsg();

    while (true) {
      printNumCases();

      String spellChoice = reader.readLine();

      switch(spellChoice) {
        case "0": {
          spellingType = false;
          break;
        }
        case "1": {
          spellingType = true;
          break;
        }
        default:
          cleanScreen();
          print("What did you entered? Are you stupid sucker!");
          break;
      }

      if (spellingType != null) {
        break;
      }
    }
  }
}
