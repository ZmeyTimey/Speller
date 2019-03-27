package by.timey.speller.view;

import by.timey.speller.util.ConsoleReader;
import lombok.Getter;

import static by.timey.speller.view.MainViewer.cleanScreen;
import static by.timey.speller.view.MainViewer.print;

public class SpellingTypeDialogViewer {

  private ConsoleReader reader;

  @Getter
  private Boolean spellingType;

  public SpellingTypeDialogViewer(ConsoleReader reader) {
    this.reader = reader;
  }

  private void printSpellingChoiceMsg() {
    print("Выберете вид спеллинга:");
  }

  public void startDialog() {
    printSpellingChoiceMsg();

    String spellChoice = "";

    while (true) {
      print("English to Russian - 0, Russian to English - 1");

      spellChoice = reader.readLine();

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
          print("Шо ты, дятел, вводишь? Читай внимательно!");
          break;
      }

      if (spellingType != null) {
        break;
      }
    }
  }
}
