package edu.neu.ccs.cs5004.model;

import java.util.Objects;

/**
 * Represents a file name.
 */
public class FileName {
  private String fileName;

  /**
   * Creates a new file name with the given file name.
   *
   * @param fileName the given file name
   */
  public FileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Return the file name.
   *
   * @return String
   */
  public String getFileName() {
    return fileName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    FileName fileName1 = (FileName) other;
    return Objects.equals(fileName, fileName1.fileName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(fileName);
  }
}
