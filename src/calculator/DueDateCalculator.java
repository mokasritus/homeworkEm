package calculator;

import java.time.LocalDateTime;

public class DueDateCalculator {

  public static void main(String[] args) throws Exception {
    if(args.length == 0 || args.length == 1) {
      System.out.println("Please provide neccesary parameters (submit date, turnaround time)\nProgram usage: java calculator/DueDateCalculator dateTime turnaroundTime(in hours)");
      System.exit(0);
    }

    LocalDateTime submitDate = LocalDateTime.parse(args[0]);
    int turnaroundTime=(Integer.parseInt(args[1]));

    Helper helper = new Helper();
    LocalDateTime resolvedTime = helper.setResolvedTime(submitDate, turnaroundTime % 8);
    LocalDateTime resolvedDate = helper.setResolvedDate(resolvedTime, turnaroundTime / 8);

    System.out.println(resolvedDate);
  }
}
