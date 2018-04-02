package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represent all the member information in the input file.
 */
public class Members {
  private List<MemberInfo> membersInfo;
  private Map<Header, Integer> headerMap;

  public Members() {
    this.membersInfo = new ArrayList<>();
    this.headerMap = new HashMap<>();
  }

  public List<MemberInfo> getMembersInfo() {
    return membersInfo;
  }

  public Map<Header, Integer> getHeaderMap() {
    return headerMap;
  }
}
