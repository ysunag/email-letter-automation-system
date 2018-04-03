package edu.neu.ccs.cs5004.process;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import edu.neu.ccs.cs5004.model.FileName;
import edu.neu.ccs.cs5004.model.MemberInfo;
import edu.neu.ccs.cs5004.model.Members;

import static org.junit.Assert.*;

public class ReaderTest {
  private Reader reader;

  @Before
  public void setUp() throws Exception {
    reader = new Reader();
  }

  @Test
  public void readMembersInfo() {
    Members members = new Members();
    FileName fileName = new FileName("abc.txt");
    reader.readMembersInfo(fileName, members);
  }

  @Test
  public void readTemplates() {
    FileName fileName = new FileName("abc.txt");
    reader.readTemplates(fileName);
  }
}