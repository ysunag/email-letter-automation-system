package edu.neu.ccs.cs5004;

import java.util.Objects;

/**
 * Represents the headers in a member information file.
 */
public class Header {
  private String headerName;

  public Header(String headerName) {
    this.headerName = headerName;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Header header = (Header) object;
    return header.headerName.equals(this.headerName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(headerName);
  }
}
