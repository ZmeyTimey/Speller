package by.timey.speller.main.util;

import by.timey.speller.main.exception.ConsoleReaderException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ConsoleReader {

  private BufferedReader bufferedReader;

  public ConsoleReader() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }

  public String readLine() {

    String readLine;

    try {
      readLine = bufferedReader.readLine();
    } catch (IOException e) {
      throw new ConsoleReaderException(e.getMessage());
    }
    return readLine;
  }
}
