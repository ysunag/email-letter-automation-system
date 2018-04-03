package edu.neu.ccs.cs5004.model;

/**
 * Represents the template for generating emails to members.
 */
public class EmailTemplate extends AbstractTemplate {

  /**
   * Creates a new email template with the given template file name.
   *
   * @param templateName the given template file name
   */
  public EmailTemplate(FileName templateName) {
    super(templateName);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    if (!super.equals(other)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {

    return super.hashCode() * 23 + 23;
  }

}
