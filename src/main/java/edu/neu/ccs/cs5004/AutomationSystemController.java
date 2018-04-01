package edu.neu.ccs.cs5004;

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
    for(MemberInfo member : members.getMembersInfo()) {
      write.writeIntoDir(parser.getDirPath(), generator.replacePlaceHolder(member));
    }
  }

}
