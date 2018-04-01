package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTemplateTest {

  private EmailTemplate emailTemplateTest;
  private EmailTemplate sameRefEmailTemplateTest;
  private EmailTemplate sameStateEmailTemplateTest;
  private EmailTemplate diffEmailTemplate;
  @Before
  public void setUp() throws Exception {
    emailTemplateTest = new EmailTemplate(new FileName("Email-template.txt"));
    sameRefEmailTemplateTest = emailTemplateTest;
    sameStateEmailTemplateTest = new EmailTemplate(new FileName("Email-template.txt"));
    diffEmailTemplate = new EmailTemplate(new FileName("d.txt"));
  }

  @Test
  public void equals() {
    EmailTemplate nullEmailTemplateTest = null;
    EmailTemplate anotherEmailTemplateTest = new EmailTemplate
            (new FileName("Email-template.txt"));
    Assert.assertTrue(emailTemplateTest.equals(sameRefEmailTemplateTest));
    Assert.assertTrue(emailTemplateTest.equals(sameStateEmailTemplateTest));
    Assert.assertEquals(emailTemplateTest.equals(sameStateEmailTemplateTest),
            sameStateEmailTemplateTest.equals(emailTemplateTest));
    Assert.assertEquals(emailTemplateTest.equals(sameStateEmailTemplateTest)
                    && sameStateEmailTemplateTest.equals(anotherEmailTemplateTest),
            emailTemplateTest.equals(anotherEmailTemplateTest));
    Assert.assertFalse(emailTemplateTest.equals(nullEmailTemplateTest));
    Assert.assertFalse(emailTemplateTest.equals(new Integer(9)));
    Assert.assertFalse(emailTemplateTest.equals(new LetterTemplate
            (new FileName("letter-template.txt"))));
    Assert.assertFalse(emailTemplateTest.equals(diffEmailTemplate));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(emailTemplateTest.equals(sameStateEmailTemplateTest),
            emailTemplateTest.hashCode() == sameStateEmailTemplateTest.hashCode());
    Assert.assertEquals(emailTemplateTest.equals(sameRefEmailTemplateTest),
            emailTemplateTest.hashCode() == sameRefEmailTemplateTest.hashCode());
    Assert.assertEquals(!emailTemplateTest.equals(new LetterTemplate
            (new FileName("letter-template.txt"))),
            emailTemplateTest.hashCode() != new LetterTemplate
                    (new FileName("letter-template.txt")).hashCode());
    Assert.assertEquals(!emailTemplateTest.equals(diffEmailTemplate),
            emailTemplateTest.hashCode() != diffEmailTemplate.hashCode());
  }
}