package edu.neu.ccs.cs5004;

/**
 * Represents running a automation system.
 */
public class Run {
  public static void main(String[] args) {
    AutomationSystemController controller = new AutomationSystemController(args);
    controller.generateMessages();
  }
}
