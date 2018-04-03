package edu.neu.ccs.cs5004.model;

/**
 * Represents an action of generate communicating files.
 */
public interface Action {
  String EMAIL = "--email";
  String LETTER = "--letter";

  /**
   * Creates a new action according to the given argument.
   *
   * @param arg the given argument
   * @return an email action if the given argument is "--email", or a letter action if the given
   *        argument is "--letter"
   */
  static Action createAction(String arg) {
    if (arg.equals(EMAIL)) {
      return new Email();
    } else if (arg.equals(LETTER)) {
      return new Letter();
    } else {
      return null;
    }
  }
}
