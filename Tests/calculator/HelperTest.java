package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

public class HelperTest {
  Helper helper = new Helper();

  @Test
  public void setResolvedTime_whenGivenDateTimeAndHours_thenSetRigthTime() throws Exception {
    LocalDateTime submitDate = LocalDateTime.parse("2021-06-17T14:00:41.82");
    int hours = 6;
    LocalDateTime expectedTime = LocalDateTime.parse("2021-06-18T12:00:41.82");
    Assert.assertEquals(expectedTime, helper.setResolvedTime(submitDate, hours));
  }

  @Test
  public void setResolvedDTime_whenGivenHours_thenThrowException() throws Exception {
    LocalDateTime submitDate = null;
    int hours = 5;
    assertThrows(Exception.class, () -> helper.setResolvedTime(submitDate, hours));
  }

  @Test
  public void setResolvedDate_whenGivenDateTimeAndDays_thenSetRigthTime() throws Exception {
    LocalDateTime submitDate = LocalDateTime.parse("2021-06-18T12:00:41.82");
    int days = 1;
    LocalDateTime expectedTime = LocalDateTime.parse("2021-06-21T12:00:41.82");
    Assert.assertEquals(expectedTime, helper.setResolvedDate(submitDate, days));
  }

  @Test
  public void setResolvedDate_whenGivenDays_thenThrowException() throws Exception {
    LocalDateTime submitDate = null;
    int days = 5;
    assertThrows(Exception.class, () -> helper.setResolvedDate(submitDate, days));
  }
}

