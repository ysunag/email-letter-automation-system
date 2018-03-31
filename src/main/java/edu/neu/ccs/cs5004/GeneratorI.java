package edu.neu.ccs.cs5004;

import java.util.List;

/**
 * Represents the process of generating a communicating file to a member.
 */
public interface GeneratorI {
  static GeneratorI createGenerator(List<String> templateContents, Members members) {
    return new Generator(templateContents, members);
  }

  List<String> replacePlaceHolder(MemberInfo member);
}
