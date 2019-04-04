package by.timey.speller.view.dialog;

import by.timey.speller.main.util.ConsoleReader;
import by.timey.speller.view.ViewConstantStore;
import lombok.Getter;

import static by.timey.speller.view.MainConsoleViewer.cleanScreen;
import static by.timey.speller.view.MainConsoleViewer.print;
import static by.timey.speller.view.ViewConstantStore.*;

public class SpellingTypeDialogViewer implements DialogViewer {

  private ConsoleReader reader;

  @Getter
  private Boolean spellingType;

  public SpellingTypeDialogViewer(ConsoleReader reader) {
    this.reader = reader;
  }

  private void printSpellingChoiceMsg() {
    print(DIALOG_SPELLTYPE_MESSAGE);
  }
  private void printNumCases() {
    print(DIALOG_SPELLTYPE_CHOICE);
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
          print(DIALOG_SPELLTYPE_ERROR);
          break;
      }

      if (spellingType != null) {
        break;
      }
    }
  }
}
