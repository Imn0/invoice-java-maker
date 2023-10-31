package fak.tura;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.*;


class StringUtilTest {

  @Test
  void parseStringToValue1() {
    String str = "1.3";
    int[] a = StringUtil.parseStringToValue(str);

    assertEquals(1, a[0]);
    assertEquals(30, a[1]);

  }
  @Test
  void parseStringToValue2() {
    String str = "1";
    int[] a = StringUtil.parseStringToValue(str);

    assertEquals(1, a[0]);
    assertEquals(0, a[1]);

  }
  @Test
  void parseStringToValue3() {
    String str = "1.03";
    int[] a = StringUtil.parseStringToValue(str);

    assertEquals(1, a[0]);
    assertEquals(3, a[1]);
  }
  @Test
  void parseStringToValue4() {
    String str = "1.03";
    int[] a = StringUtil.parseStringToValue(str);

    assertEquals(1, a[0]);
    assertEquals(3, a[1]);
  }
  @Test
  void parseStringToValue5() {
    String str = "-1.03";
    assertThrows(NumberFormatException.class, (Executable) () -> {StringUtil.parseStringToValue(str);});
  }
  @Test
  void parseStringToValue6() {
    String str = "aaaaa.03";
    assertThrows(NumberFormatException.class, (Executable) () -> {StringUtil.parseStringToValue(str);});
  }

  @Test
  void parseStringToValue7() {
    String str = "3.-03";
    assertThrows(NumberFormatException.class, (Executable) () -> {StringUtil.parseStringToValue(str);});
  }

}