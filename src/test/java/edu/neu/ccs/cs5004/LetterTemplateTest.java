package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class LetterTemplateTest {

  private LetterTemplate letterTemplateTest;
  private LetterTemplate sameRefLetterTemplateTest;
  private LetterTemplate sameStateLetterTemplateTest;
  private LetterTemplate diffLetterTemplate;
  @Before
  public void setUp() throws Exception {
    letterTemplateTest = new LetterTemplate(new FileName("letter-template.txt"));
    sameRefLetterTemplateTest = letterTemplateTest;
    sameStateLetterTemplateTest = new LetterTemplate(new FileName("letter-template.txt"));
    diffLetterTemplate = new LetterTemplate(new FileName("d.txt"));
  }

  @Test
  public void equals() {
    LetterTemplate nullLetterTemplateTest = null;
    LetterTemplate anotherLetterTemplateTest = new LetterTemplate
            (new FileName("letter-template.txt"));
    Assert.assertTrue(letterTemplateTest.equals(sameRefLetterTemplateTest));
    Assert.assertTrue(letterTemplateTest.equals(sameStateLetterTemplateTest));
    Assert.assertEquals(letterTemplateTest.equals(sameStateLetterTemplateTest),
            sameStateLetterTemplateTest.equals(letterTemplateTest));
    Assert.assertEquals(letterTemplateTest.equals(sameStateLetterTemplateTest)
            && sameStateLetterTemplateTest.equals(anotherLetterTemplateTest),
            letterTemplateTest.equals(anotherLetterTemplateTest));
    Assert.assertFalse(letterTemplateTest.equals(nullLetterTemplateTest));
    Assert.assertFalse(letterTemplateTest.equals(new Integer(9)));
    Assert.assertFalse(letterTemplateTest.equals(new EmailTemplate
            (new FileName("email-template.txt"))));
    Assert.assertFalse(letterTemplateTest.equals(diffLetterTemplate));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(letterTemplateTest.equals(sameStateLetterTemplateTest),
            letterTemplateTest.hashCode() == sameStateLetterTemplateTest.hashCode());
    Assert.assertEquals(letterTemplateTest.equals(sameRefLetterTemplateTest),
            letterTemplateTest.hashCode() == sameRefLetterTemplateTest.hashCode());
    Assert.assertEquals(!letterTemplateTest.equals(new EmailTemplate
                    (new FileName("email-template.txt"))),
            letterTemplateTest.hashCode() != new EmailTemplate
                    (new FileName("email-template.txt")).hashCode());
    Assert.assertEquals(!letterTemplateTest.equals(diffLetterTemplate),
            letterTemplateTest.hashCode() != diffLetterTemplate.hashCode());
  }
}