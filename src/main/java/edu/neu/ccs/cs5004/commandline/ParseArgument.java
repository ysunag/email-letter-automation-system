package edu.neu.ccs.cs5004.commandline;

import edu.neu.ccs.cs5004.model.Action;
import edu.neu.ccs.cs5004.model.DirPath;
import edu.neu.ccs.cs5004.model.FileName;
import edu.neu.ccs.cs5004.model.Template;

import java.util.Arrays;



/**
 * Represents parsing the command line arguments to get information for the automation system.
 */
public class ParseArgument {
  private String[] args;
  public static final String DIRECTORY = "--output-dir";
  public static final String INPUTFILE = "--csv-file";
  public static final String TEMPLATE = "-template";

  /**
   * Creates a new argument parser with given command line arguments.
   * @param args given command line arguments
   */
  public ParseArgument(String[] args) {
    this.args = new String[args.length];
    int index = 0;
    for (String str: args) {
      this.args[index] = str;
      index++;
    }
  }

  /**
   * Check if an argument is a switch.
   * @param arg the argument to check
   * @return true if the argument is a switch, false otherwise
   */
  protected boolean isSwitch(String arg) {
    return arg.charAt(0) == '-' && arg.charAt(1) == '-';
  }

  /**
   * Check if the command line arguments are valid.
   * @return empty string if the arguments are valid, error message if the arguments are
   *        invalid.
   */
  public String checkArguments() {
    String res = "";
    if (getAction() == null) {
      res += "Error: no action provided.\n";
    }

    if (getTemplate() == null && getAction() != null) {
      res += "Error: " + getAction().toString() + " provided but no " + getAction().toString()
                + TEMPLATE + " was given.\n";
    }

    if (getDirPath() == null) {
      res += "Error: output directory was not given.\n";
    }
    if (getInput() == null) {
      res += "Error: member information file was not given.\n";
    }
    if (!res.equals("")) {
      res += "Usage:\n\n"
              + "        --email                        only generate email messages\n"
              + "        --email-template <file>  accepts a filename that holds the email "
              + "template.\n"
              + "          Required if --email is used\n\n"
              + "        --letter                        only generate letters\n"
              + "        --letter-template <file> accepts a filename that holds the email "
              + "template.\n"
              + "          Required if --letter is used\n\n"
              + "        --output-dir <path> accepts the name of a folder, all output is placed "
              + "in this folder\n"
              + "\n"
              + "        --csv-file <path> accepts the name of the csv file to process\n";
    }
    return res;

  }

  /**
   * Gets the action requested.
   * @return the action requested
   */
  public Action getAction() {
    Action action  = null;
    int index = 0;
    while (action == null && index < args.length) {
      action = Action.createAction(args[index]);
      index++;
    }
    return action;
  }

  /**
   * Gets the template provided.
   * @return the template provided
   */
  public Template getTemplate() {
    Action action = getAction();
    if (action != null) {
      for (int i = 0; i < args.length - 1; i++) {
        if (args[i].equals(action.toString() + TEMPLATE) && !isSwitch(args[i + 1])) {
          return Template.createTemplate(action, args[i + 1]);
        }
      }
    }
    return null;

  }

  /**
   * Gets the directory path where to write the output in.
   * @return the directory path where to write the output in
   */
  public DirPath getDirPath() {
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals(DIRECTORY) && !isSwitch(args[i + 1])) {
        return new DirPath(args[i + 1]);
      }
    }
    return null;
  }

  /**
   * Gets the input file name.
   * @return the input file name
   */
  public FileName getInput() {
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals(INPUTFILE) && !isSwitch(args[i + 1])) {
        return new FileName(args[i + 1]);
      }
    }
    return null;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    ParseArgument that = (ParseArgument) other;
    return Arrays.equals(args, that.args);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(args);
  }
}
