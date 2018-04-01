package edu.neu.ccs.cs5004;

import java.util.Objects;

/**
 * Represents a template to communicate with members.
 */
public abstract class AbstractTemplate implements Template{
  private FileName templateName;

  /**
   * Creates a new abstract template with the given template name.
   * @param templateName the given template name
   */
  public AbstractTemplate(FileName templateName) {
    this.templateName = templateName;
  }

  /**
   * Getter for the property 'templateName'.
   * @return Value for property 'templateName'
   */
  public FileName getTemplateName() {
    return templateName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    AbstractTemplate that = (AbstractTemplate) other;
    return Objects.equals(getTemplateName(), that.getTemplateName());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getTemplateName());
  }
}
