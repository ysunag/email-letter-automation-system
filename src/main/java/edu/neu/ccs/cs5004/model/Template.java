package edu.neu.ccs.cs5004.model;

import edu.neu.ccs.cs5004.commandline.Action;

/**
 * Represents a template to communicate with members.
 */
public interface Template {
  /**
   * Creates a new template with given template file name according to the given action type.
   *
   * @param action       the given action type
   * @param templateName the given template file name
   * @return a new email template with the given file name if the action is an email, or a new
   * letter template with the given file name if the action is a letter.
   */
  static Template createTemplate(Action action, String templateName) {
    if (action.equals(new Email())) {
      return new EmailTemplate(new FileName(templateName));
    } else if (action.equals(new Letter())) {
      return new LetterTemplate(new FileName(templateName));
    } else {
      return null;
    }
  }

  /**
   * Return the file name of the template.
   *
   * @return the file name of the template
   */
  FileName getTemplateName();
}
