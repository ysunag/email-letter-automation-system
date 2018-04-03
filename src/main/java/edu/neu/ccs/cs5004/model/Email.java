package edu.neu.ccs.cs5004.model;

import edu.neu.ccs.cs5004.commandline.Action;

/**
 * Represents the action of generating email to members.
 */
public class Email implements Action {
  @Override
  public String toString() {
    return "--email";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {

    return 31;
  }

}
