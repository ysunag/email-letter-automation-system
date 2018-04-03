package edu.neu.ccs.cs5004.model;

/**
 * Represents the action of generating letter to members.
 */
public class Letter implements Action {

  @Override
  public String toString() {
    return "--letter";
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

    return 41;
  }
}
