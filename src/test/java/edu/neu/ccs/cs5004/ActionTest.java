package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Test;

import edu.neu.ccs.cs5004.commandline.Action;
import edu.neu.ccs.cs5004.model.Email;
import edu.neu.ccs.cs5004.model.Letter;

public class ActionTest {

  @Test
  public void createAction() {
    Assert.assertEquals(new Email(), Action.createAction("--email"));
    Assert.assertEquals(new Letter(), Action.createAction("--letter"));
  }
}