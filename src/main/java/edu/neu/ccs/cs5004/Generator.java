package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents the process of generating a communicating file to a member.
 */
public class Generator implements GeneratorI {
  private List<String> templateContents;
  private Map<Header, Integer> headerMap;

  public Generator(List<String> templateContents, Members members) {
    this.templateContents = templateContents;
    this.headerMap = members.getHeaderMap();
  }

  public List<String> replacePlaceHolder(MemberInfo member) {
    List<String> result = new ArrayList<>();
    for (String str : templateContents) {
      String line = new String(str);
      int index = line.indexOf("[[");
      while (index > 0) {
        int end = line.indexOf("]]", index);
        String template = line.substring(index + 2, end);
        int i = headerMap.get(new Header(template));
        line = line.replaceAll("\\[\\[" + template + "\\]\\]", member.getInfo()[i]);
        index = line.indexOf("[[");
      }
      result.add(line);
    }
    return result;
  }


}
