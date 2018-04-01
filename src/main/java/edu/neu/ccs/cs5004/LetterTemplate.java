package edu.neu.ccs.cs5004;


/**
 * Represents the template for generating letters to members.
 */
public class LetterTemplate extends AbstractTemplate{
  /**
   * Creates a new letter template with the given template file name.
   * @param templateName the given template file name
   */
  public LetterTemplate(FileName templateName) {
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

    return super.hashCode() * 53 + 53;
  }
}
