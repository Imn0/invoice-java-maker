package fak.tura;

public class StringUtil {
  public static int[] parseStringToValue(String str) throws NumberFormatException{
    str += ".00";
    String[] arrOfstr = str.split("[.]");
    int czescCalkowita;
    int czescUlamkowa;
    try {
      czescCalkowita = Integer.parseInt(arrOfstr[0]);
    } catch (Exception e){
      throw new NumberFormatException("niepoprawna wartosc całkowita");
    }
    if (czescCalkowita < 0) {
      throw new NumberFormatException("niepoprawna wartosc całkowita");
    }

    try {
      String ulamek = arrOfstr[1] + "0" + "0";
      czescUlamkowa = Character.getNumericValue(ulamek.charAt(0)) * 10 + Character.getNumericValue(ulamek.charAt(1));
    } catch (Exception e){
      throw new NumberFormatException("niepoprawna wartosc ułamkowa");
    }
    if (czescUlamkowa < 0 || czescUlamkowa > 99) {
      throw new NumberFormatException("niepoprawna wartosc ułamkowa");
    }

    return new int[]{czescCalkowita, czescUlamkowa};
  }


  private StringUtil(){

  }
}
