package fak.tura;

public class StringUtil {

  public static int[] parseStringToValue(String str) throws NumberFormatException{
    return parseStringToValue(str, 2);
  }
  public static int[] parseStringToValue(String str, int decimalPlaces) throws NumberFormatException{
    str += ".00";
    String[] arrOfstr = str.split("[.]");
    int czescCalkowita;
    int czescUlamkowa;
    try {
      czescCalkowita = Integer.parseInt(arrOfstr[0]);
    } catch (Exception e){
      throw new NumberFormatException("niepoprawna wartość całkowita");
    }
    if (czescCalkowita < 0) {
      throw new NumberFormatException("niepoprawna wartość całkowita");
    }

    try {
      String ulamek = arrOfstr[1] + "000";
      czescUlamkowa = Character.getNumericValue(ulamek.charAt(0)) * 100 + Character.getNumericValue(ulamek.charAt(1))* 10 + Character.getNumericValue(ulamek.charAt(2));
    } catch (Exception e){
      throw new NumberFormatException("niepoprawna wartość ułamkowa");
    }
    if (czescUlamkowa < 0 || czescUlamkowa > 999) {
      throw new NumberFormatException("niepoprawna wartość ułamkowa");
    }

    return switch (decimalPlaces) {
      case 1 -> new int[]{czescCalkowita, czescUlamkowa / 100};
      case 2 -> new int[]{czescCalkowita, czescUlamkowa / 10};
      default -> new int[]{czescCalkowita, czescUlamkowa};
    };
  }

  public static String getStringFromValue(int value) throws NumberFormatException{
    if(value < 0){
      throw new NumberFormatException("nie można przekonwertować ujemnej liczby");
    }

    String tmp = Integer.toString(value);
    if (tmp.length() < 3){
      tmp = "0" + tmp;
    }
    if (tmp.length() < 3){
      tmp = "0" + tmp;
    }
    return tmp.substring(0, tmp.length()-2) + "." + tmp.substring(tmp.length()-2);
  }

  private StringUtil(){

  }
}
