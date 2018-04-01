package edu.neu.ccs.cs5004;

import java.util.List;
import java.util.Map;

/**
 * Represents the process of generating a communicating file to a member.
 */
public class Generator implements GeneratorI{
  private List<String> templateContents;
  private Map<Header, Integer> headerMap;

  public Generator(List<String> templateContents, Members members) {
    this.templateContents = templateContents;
    this.headerMap = members.getHeaderMap();
  }

  public List<String> replacePlaceHolder(MemberInfo member) {
    return null;
  }



}
