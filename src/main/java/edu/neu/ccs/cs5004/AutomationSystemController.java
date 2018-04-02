package edu.neu.ccs.cs5004;

import java.io.File;

/**
 * Represents the automation system to generate communicating files.
 */
public class AutomationSystemController {
  private Reader reader;
  private Write write;
  private ParseArgument parser;

  public AutomationSystemController(String[] args) {
    reader = new Reader();
    write = new Write();
    parser = new ParseArgument(args);
  }

  public void runAutomationSystem() {
    String error = parser.checkArguments();
    if (error != "") {
      throw new IllegalArgumentException(error);
    }
    generateMessages();
  }

  protected void generateMessages() {
    Members members = new Members();
    reader.readMembersInfo(parser.getInput(), members);
    GeneratorI generator = GeneratorI.createGenerator(
            reader.readTemplates(parser.getTemplate().getTemplateName()), members);
    String path = "./src/main/java/edu/neu/ccs/cs5004/" + parser.getDirPath().getDirPath();
    File dir = new File(path);
    dir.mkdir();
    int i = 0;
    for (MemberInfo member : members.getMembersInfo()) {
      write.writeIntoDir(path + "/" + i++ + ".txt",
              generator.replacePlaceHolder(member));
    }
  }
}
