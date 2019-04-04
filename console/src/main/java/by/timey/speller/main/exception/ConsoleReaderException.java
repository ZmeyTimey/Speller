package by.timey.speller.main.exception;

public class ConsoleReaderException extends RuntimeException {
  public ConsoleReaderException() {
  }

  public ConsoleReaderException(String message) {
    super(message);
  }

  public ConsoleReaderException(String message, Throwable cause) {
    super(message, cause);
  }

  public ConsoleReaderException(Throwable cause) {
    super(cause);
  }
}
