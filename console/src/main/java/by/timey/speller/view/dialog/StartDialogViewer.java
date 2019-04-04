package by.timey.speller.view.dialog;

import by.timey.speller.main.util.ConsoleReader;
import lombok.Getter;

import static by.timey.speller.view.MainConsoleViewer.cleanScreen;
import static by.timey.speller.view.MainConsoleViewer.print;
import static by.timey.speller.view.ViewConstantStore.DIALOG_START;

public class StartDialogViewer implements DialogViewer {

  private ConsoleReader reader;

  public StartDialogViewer(ConsoleReader reader) {
    this.reader = reader;
  }

  @Getter
  private Boolean continueOrExit;

  private void printDialogMsg() {
    print(DIALOG_START);
  }

  public void startDialog() {
    while (true) {
      printDialogMsg();

      String input = reader.readLine();

      switch (input) {
        case "s": {
          continueOrExit = true;
          break;
        }
        case "e": {
          continueOrExit = false;
          break;
        }
        default:
          cleanScreen();
          break;
      }

      if (continueOrExit != null) {
        break;
      }
    }
  }
}
