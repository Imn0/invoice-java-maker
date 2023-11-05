package fak.tura;



import fak.tura.logic.StringUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class StringUtilTest {

  @Test
  public void parseStringToValue1() {
    String str = "1.30";
    int[] a = StringUtil.parseStringToValue(str);

    assertEquals(1, a[0]);
    assertEquals(30, a[1]);
  }
  @Test
  public void parseStringToValue2() {
    String str = "1";
    int[] a = StringUtil.parseStringToValue(str);

    assertEquals(1, a[0]);
    assertEquals(0, a[1]);

  }
  @Test
  public void parseStringToValue3() {
    String str = "1.03";
    int[] a = StringUtil.parseStringToValue(str);

    assertEquals(1, a[0]);
    assertEquals(3, a[1]);
  }
  @Test
  public void parseStringToValue4() {
    String str = "1.03";
    int[] a = StringUtil.parseStringToValue(str);

    assertEquals(1, a[0]);
    assertEquals(3, a[1]);
  }
  @Test
  public void parseStringToValue5() {
    String str = "-1.03";
    assertThrows(NumberFormatException.class, () -> {StringUtil.parseStringToValue(str);});
  }
  @Test
  public void parseStringToValue6() {
    String str = "aaaaa.03";
    assertThrows(NumberFormatException.class,  () -> {StringUtil.parseStringToValue(str);});
  }
  @Test
  public void parseStringToValue7() {
    String str = "3.-03";
    assertThrows(NumberFormatException.class,  () -> {StringUtil.parseStringToValue(str);});
  }
  @Test
  public void parseStringToValue8() {
    String str = "1.303";
    int[] a = StringUtil.parseStringToValue(str,3);

    assertEquals(1, a[0]);
    assertEquals(303, a[1]);
  }
  @Test
  public void parseStringToValue9() {
    String str = "1.303";
    int[] a = StringUtil.parseStringToValue(str,1);

    assertEquals(1, a[0]);
    assertEquals(3, a[1]);
  }
  @Test
  public void parseStringToValue10() {
    String str = "1.303";
    int[] a = StringUtil.parseStringToValue(str,2);

    assertEquals(1, a[0]);
    assertEquals(30, a[1]);
  }
  @Test
  public void getStringFromValue1() {
    String str = "0.00";
    assertEquals(str, StringUtil.getStringFromValue(0));
  }
  @Test
  public void getStringFromValue2() {
    String str = "0.03";
    assertEquals(str, StringUtil.getStringFromValue(3));
  }
  @Test
  public void getStringFromValue3() {
    String str = "0.20";
    assertEquals(str, StringUtil.getStringFromValue(20));
  }
  @Test
  public void getStringFromValue4() {
    String str = "12.03";
    assertEquals(str, StringUtil.getStringFromValue(1203));
  }
  @Test
  public void getStringFromValue5() {
    String str = "1420.30";
    assertEquals(str, StringUtil.getStringFromValue(142030));
  }
  @Test
  public void getStringFromValue6() {
    assertThrows(NumberFormatException.class, () -> {StringUtil.getStringFromValue(-2);});
  }
  @Test
  public void getStringFromValue7() {
    assertThrows(NumberFormatException.class, () -> {StringUtil.getStringFromValue(-12);});
  }
}