package by.timey.speller.main.util;

import lombok.Getter;

@Getter
public class AnswerCounter {

  private int correctAnswers;
  private int incorrectAnswers;

  public AnswerCounter() {
    correctAnswers = 0;
    incorrectAnswers = 0;
  }

  public void reset() {
    correctAnswers = 0;
    incorrectAnswers = 0;
  }

  public void correct() {
    correctAnswers++;
  }

  public void incorrect() {
    incorrectAnswers++;
  }
}
