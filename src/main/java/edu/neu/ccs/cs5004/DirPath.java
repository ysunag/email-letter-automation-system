package edu.neu.ccs.cs5004;


import java.util.Objects;

/**
 * Represents a directory.
 */
public class DirPath {
  private String dirPath;

  /**
   * Creates a new directory path with the given directory path.
   *
   * @param dirPath the given directory path
   */

  public DirPath(String dirPath) {
    this.dirPath = dirPath;
  }

  /**
   * Getter for property 'dirpath'.
   *
   * @return Value for property 'dirpath'
   */

  public String getDirPath() {
    return dirPath;
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    DirPath dirPath1 = (DirPath) other;
    return Objects.equals(dirPath, dirPath1.dirPath);
  }

  @Override
  public int hashCode() {

    return Objects.hash(dirPath);
  }
}

