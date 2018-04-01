package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TemplateTest {

  @Test
  public void createTemplate() {
    Assert.assertEquals(new EmailTemplate(new FileName("email-template.txt")),
            Template.createTemplate(new Email(), "email-template.txt"));
    Assert.assertEquals(new LetterTemplate(new FileName("letter-template.txt")),
            Template.createTemplate(new Letter(), "letter-template.txt"));
  }

}