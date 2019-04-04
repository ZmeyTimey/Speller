package by.timey.speller.main;

import by.timey.speller.main.config.SpringMainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static by.timey.speller.view.MainConsoleViewer.cleanScreen;
import static by.timey.speller.view.MainConsoleViewer.printHeader;

public class Runner {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(SpringMainConfig.class);
    context.refresh();

    cleanScreen();
    printHeader();

    Speller speller = context.getBean(Speller.class);
    speller.start();
  }
}
