package by.timey.speller.view;

import by.timey.speller.main.util.ConsoleReader;
import lombok.Getter;

import static by.timey.speller.view.MainConsoleViewer.cleanScreen;
import static by.timey.speller.view.MainConsoleViewer.print;

public class StartDialogViewer {

  private ConsoleReader reader;

  public StartDialogViewer(ConsoleReader reader) {
    this.reader = reader;
  }

  @Getter
  private Boolean continueOrExit;

  private void printDialogMsg() {
    print("Enter \"s\" to start new spelling or enter \"e\" to exit the app");
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
