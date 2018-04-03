package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.Email;
import edu.neu.ccs.cs5004.model.Letter;

public class LetterTest {
  private Letter letterTest;
  private Letter sameRefLetterTest;
  private Letter sameStateLetterTest;
  @Before
  public void setUp() throws Exception {
    letterTest = new Letter();
    sameRefLetterTest = letterTest;
    sameStateLetterTest = new Letter();
  }

  @Test
  public void testToString() {
    Assert.assertEquals("--letter", letterTest.toString());
  }

  @Test
  public void equals() {
    Letter nullLetterTest = null;
    Letter anotherLetterTest = new Letter();
    Assert.assertTrue(letterTest.equals(sameRefLetterTest));
    Assert.assertTrue(letterTest.equals(sameStateLetterTest));
    Assert.assertEquals(letterTest.equals(sameStateLetterTest),
            sameStateLetterTest.equals(letterTest));
    Assert.assertEquals(letterTest.equals(sameStateLetterTest)
                    && sameStateLetterTest.equals(anotherLetterTest),
            letterTest.equals(anotherLetterTest));
    Assert.assertFalse(letterTest.equals(nullLetterTest));
    Assert.assertFalse(letterTest.equals(new Integer(9)));
    Assert.assertFalse(letterTest.equals(new Email()));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(letterTest.equals(sameStateLetterTest),
            letterTest.hashCode() == sameStateLetterTest.hashCode());
    Assert.assertEquals(letterTest.equals(sameRefLetterTest),
            letterTest.hashCode() == sameRefLetterTest.hashCode());
    Assert.assertEquals(!letterTest.equals(new Email()),
            letterTest.hashCode() != new Email().hashCode());
  }
}