package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.AbstractTemplate;
import edu.neu.ccs.cs5004.model.EmailTemplate;
import edu.neu.ccs.cs5004.model.FileName;

public class AbstractTemplateTest {

  private AbstractTemplate emailTemplateTest;
  @Before
  public void setUp() throws Exception {
    emailTemplateTest = new EmailTemplate(new FileName("Email-template.txt"));
  }

  @Test
  public void getTemplateName() {
    Assert.assertEquals(new FileName("Email-template.txt"), emailTemplateTest.getTemplateName());
  }
}