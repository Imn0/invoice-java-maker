package fak.tura;


//import static org.junit.jupiter.api.Assertions.*;

import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.*;


class StringUtilTest {

  @Test
  void parseStringToValue1() {
    String str = "1.30";
    int[] a = StringUtil.parseStringToValue(str);

    Assertions.assertEquals(1, a[0]);
    Assertions.assertEquals(30, a[1]);
  }
  @Test
  void parseStringToValue2() {
    String str = "1";
    int[] a = StringUtil.parseStringToValue(str);

    Assertions.assertEquals(1, a[0]);
    Assertions.assertEquals(0, a[1]);

  }
  @Test
  void parseStringToValue3() {
    String str = "1.03";
    int[] a = StringUtil.parseStringToValue(str);

    Assertions.assertEquals(1, a[0]);
    Assertions.assertEquals(3, a[1]);
  }
  @Test
  void parseStringToValue4() {
    String str = "1.03";
    int[] a = StringUtil.parseStringToValue(str);

    Assertions.assertEquals(1, a[0]);
    Assertions.assertEquals(3, a[1]);
  }
  @Test
  void parseStringToValue5() {
    String str = "-1.03";
    assertThrows(NumberFormatException.class, (ThrowingRunnable) () -> {StringUtil.parseStringToValue(str);});
  }
  @Test
  void parseStringToValue6() {
    String str = "aaaaa.03";
    assertThrows(NumberFormatException.class, (ThrowingRunnable) () -> {StringUtil.parseStringToValue(str);});
  }
  @Test
  void parseStringToValue7() {
    String str = "3.-03";
    assertThrows(NumberFormatException.class, (ThrowingRunnable) () -> {StringUtil.parseStringToValue(str);});
  }
  @Test
  void parseStringToValue8() {
    String str = "1.303";
    int[] a = StringUtil.parseStringToValue(str,3);

    Assertions.assertEquals(1, a[0]);
    Assertions.assertEquals(303, a[1]);
  }
  @Test
  void parseStringToValue9() {
    String str = "1.303";
    int[] a = StringUtil.parseStringToValue(str,1);

    Assertions.assertEquals(1, a[0]);
    Assertions.assertEquals(3, a[1]);
  }
  @Test
  void parseStringToValue10() {
    String str = "1.303";
    int[] a = StringUtil.parseStringToValue(str,2);

    Assertions.assertEquals(1, a[0]);
    Assertions.assertEquals(30, a[1]);
  }
  @Test
  void getStringFromValue1() {
    String str = "0.00";
    Assertions.assertEquals(str, StringUtil.getStringFromValue(0));
  }
  @Test
  void getStringFromValue2() {
    String str = "0.03";
    Assertions.assertEquals(str, StringUtil.getStringFromValue(3));
  }
  @Test
  void getStringFromValue3() {
    String str = "0.20";
    Assertions.assertEquals(str, StringUtil.getStringFromValue(20));
  }
  @Test
  void getStringFromValue4() {
    String str = "12.03";
    Assertions.assertEquals(str, StringUtil.getStringFromValue(1203));
  }
  @Test
  void getStringFromValue5() {
    String str = "1420.30";
    Assertions.assertEquals(str, StringUtil.getStringFromValue(142030));
  }
  @Test
  void getStringFromValue6() {
    assertThrows(NumberFormatException.class, (ThrowingRunnable) () -> {StringUtil.getStringFromValue(-2);});
  }
  @Test
  void getStringFromValue7() {
    assertThrows(NumberFormatException.class, (ThrowingRunnable) () -> {StringUtil.getStringFromValue(-12);});
  }
}