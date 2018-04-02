package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a reader to reads the member information file and template file.
 */
public class Reader {

  public void readMembersInfo(FileName file, Members members) {
    String csvFile = "./src/main/java/edu/neu/ccs/cs5004/input/" + file.getFileName();
    String line;

    try (BufferedReader breader = new BufferedReader(new InputStreamReader(
            new FileInputStream(csvFile), "UTF-8"))) {

      String[] header = breader.readLine().split(",");
      for (int i = 0; i < header.length; i++) {
        header[i] = header[i].replace("\"", "");
        members.getHeaderMap().put(new Header(header[i]), i);
      }
      while ((line = breader.readLine()) != null && line.equals("")) {
        String[] info = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        for (int i = 0; i < info.length; i++) {
          info[i] = info[i].replace("\"", "");
        }
        MemberInfo memberInfo = new MemberInfo(info);
        members.getMembersInfo().add(memberInfo);
      }

    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  public List<String> readTemplates(FileName file) {
    String csvFile = "./src/main/java/edu/neu/ccs/cs5004/input/" + file.getFileName();
    String line;
    List<String> result = new ArrayList<>();
    try (BufferedReader breader = new BufferedReader(new InputStreamReader(
            new FileInputStream(csvFile), "UTF-8"))) {
      while ((line = breader.readLine()) != null) {
        result.add(line);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
    return result;
  }

}
