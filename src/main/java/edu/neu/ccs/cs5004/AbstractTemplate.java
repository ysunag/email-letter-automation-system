package edu.neu.ccs.cs5004;

/**
 * Represents a template to communicate with members.
 */
public class AbstractTemplate implements Template{
  private FileName templateName;

  public FileName getTemplateName() {
    return templateName;
  }
}
