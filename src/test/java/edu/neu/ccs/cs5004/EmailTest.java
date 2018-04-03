package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.Email;
import edu.neu.ccs.cs5004.model.EmailTemplate;
import edu.neu.ccs.cs5004.model.FileName;
import edu.neu.ccs.cs5004.model.Letter;

public class EmailTest {
  private Email emailTest;
  private Email sameRefEmailTest;
  private Email sameStateEmailTest;
  @Before
  public void setUp() throws Exception {
    emailTest = new Email();
    sameRefEmailTest = emailTest;
    sameStateEmailTest = new Email();
  }

  @Test
  public void testToString() {
    Assert.assertEquals("--email", emailTest.toString());
  }

  @Test
  public void equals() {
    Email nullEmailTest = null;
    Email anotherEmailTest = new Email();
    Assert.assertTrue(emailTest.equals(sameRefEmailTest));
    Assert.assertTrue(emailTest.equals(sameStateEmailTest));
    Assert.assertEquals(emailTest.equals(sameStateEmailTest),
            sameStateEmailTest.equals(emailTest));
    Assert.assertEquals(emailTest.equals(sameStateEmailTest)
                    && sameStateEmailTest.equals(anotherEmailTest),
            emailTest.equals(anotherEmailTest));
    Assert.assertFalse(emailTest.equals(nullEmailTest));
    Assert.assertFalse(emailTest.equals(new Integer(9)));
    Assert.assertFalse(emailTest.equals(new Letter()));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(emailTest.equals(sameStateEmailTest),
            emailTest.hashCode() == sameStateEmailTest.hashCode());
    Assert.assertEquals(emailTest.equals(sameRefEmailTest),
            emailTest.hashCode() == sameRefEmailTest.hashCode());
    Assert.assertEquals(!emailTest.equals(new EmailTemplate
                    (new FileName("email-template.txt"))),
            emailTest.hashCode() != new Letter().hashCode());
  }
}