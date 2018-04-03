package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.Email;
import edu.neu.ccs.cs5004.model.EmailTemplate;
import edu.neu.ccs.cs5004.model.FileName;
import edu.neu.ccs.cs5004.model.Letter;
import edu.neu.ccs.cs5004.model.LetterTemplate;
import edu.neu.ccs.cs5004.model.Template;

public class TemplateTest {

  @Test
  public void createTemplate() {
    Assert.assertEquals(new EmailTemplate(new FileName("email-template.txt")),
            Template.createTemplate(new Email(), "email-template.txt"));
    Assert.assertEquals(new LetterTemplate(new FileName("letter-template.txt")),
            Template.createTemplate(new Letter(), "letter-template.txt"));
  }

}