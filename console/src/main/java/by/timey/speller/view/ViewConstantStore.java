package by.timey.speller.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ViewConstantStore {

  private ViewConstantStore() {}

  private static Properties property = new Properties();

  static {
    try {
      FileInputStream fis
          = new FileInputStream("core/src/main/resources/properties/spellMessages.properties");
      property.load(fis);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static final String HEADER_VERSION = property.getProperty("header.version");
  static final String HEADER_AUTHOR = property.getProperty("header.author");
  static final String HEADER_YEAR_PLACE = property.getProperty("header.year_and_place");

  public static final String DIALOG_SPELLTYPE_MESSAGE = property.getProperty("dialog.spell_type.message");
  public static final String DIALOG_SPELLTYPE_CHOICE = property.getProperty("dialog.spell_type.choice");
  public static final String DIALOG_SPELLTYPE_ERROR = property.getProperty("dialog.spell_type.error");
  public static final String DIALOG_START = property.getProperty("dialog.start");
  public static final String DIALOG_WORDS_NUMBER_MESSAGE = property.getProperty("dialog.words_number.message");
  public static final String DIALOG_WORDS_NUMBER_ERROR = property.getProperty("dialog.words_number.error");
  public static final String DIALOG_WORDS_NUMBER_TRY_AGAIN = property.getProperty("dialog.words_number.try_again");


  public static final String MESSAGE_TRANSLATE_ENGLISH = property.getProperty("message.translate.english");
  public static final String MESSAGE_TRANSLATE_RUSSIAN = property.getProperty("message.translate.russian");

  static final String MESSAGE_CORRECT = property.getProperty("message.correct");
  static final String MESSAGE_INCORRECT = property.getProperty("message.incorrect");
  static final String MESSAGE_COMPLETE = property.getProperty("message.spell_complete");
  static final String MESSAGE_GOODBYE = property.getProperty("message.goodbye");

  static final String RESULT_CORRECT_ANSWERS = property.getProperty("result.correct_answers");
  static final String RESULT_FAIL = property.getProperty("result.fail");
  static final String RESULT_SUCCESS = property.getProperty("result.success");

  static final String LINE = property.getProperty("line");
}
