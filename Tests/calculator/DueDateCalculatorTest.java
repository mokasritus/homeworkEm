package calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DueDateCalculatorTest {
  private PrintStream console;
  private ByteArrayOutputStream bytes;
  private static final String EOL =
      System.getProperty("line.separator");


  @Before
  public void setUp() {
    bytes = new ByteArrayOutputStream();
    console = System.out;
    System.setOut(new PrintStream(bytes));
  }

  @After
  public void tearDown() {
    System.setOut(console);
  }

  @Test
  public void main_whenNeccessaryArgumentsSupplied_thenExpectedResolvedDateTime() throws Exception {
    String[] input = {"2021-06-17T14:00:41.82", "14"};
    DueDateCalculator.main(input);
    String resolvedDate = "2021-06-21T12:00:41.820";
    Assert.assertEquals(resolvedDate + EOL, bytes.toString());
  }

}
