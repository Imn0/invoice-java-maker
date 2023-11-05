package fak.tura.logic;

public final class StringUtil {

    private StringUtil() {

    }

    public static int[] parseStringToValue(final String str)
            throws NumberFormatException {
        return parseStringToValue(str, 2);
    }

    public static int[] parseStringToValue(final String str, int decimalPlaces) throws NumberFormatException {
        String updatedstr = str.trim();
        updatedstr += ".00";
        String[] arrOfstr = updatedstr.split("[.]");
        int integerPart;
        int decimalPart;
        try {
            integerPart = Integer.parseInt(arrOfstr[0]);
        } catch (Exception e) {
            throw new NumberFormatException("niepoprawna wartość całkowita");
        }
        if (integerPart < 0) {
            throw new NumberFormatException("niepoprawna wartość całkowita");
        }

        try {
            String ulamek = arrOfstr[1] + "000";
            decimalPart = Character.getNumericValue(ulamek.charAt(0)) * 100 + Character.getNumericValue(ulamek.charAt(1)) * 10 + Character.getNumericValue(ulamek.charAt(2));
        } catch (Exception e) {
            throw new NumberFormatException("niepoprawna wartość całkowita");
        }
        if (decimalPart < 0 || decimalPart > 999) {
            throw new NumberFormatException("niepoprawna wartość ułamkowa");
        }

        return switch (decimalPlaces) {
            case 1 -> new int[]{integerPart, decimalPart / 100};
            case 2 -> new int[]{integerPart, decimalPart / 10};
            default -> new int[]{integerPart, decimalPart};
        };
    }

    public static String getStringFromValue(final int value) throws NumberFormatException {
        if (value < 0) {
            throw new NumberFormatException("nie można przekonwertować ujemnej liczby");
        }

        String tmp = Integer.toString(value);
        int desiredLength = 3;
        if (tmp.length() < desiredLength) {
            tmp = "0" + tmp;
        }
        if (tmp.length() < desiredLength) {
            tmp = "0" + tmp;
        }
        return tmp.substring(0, tmp.length() - 2) + "." + tmp.substring(tmp.length() - 2);
    }
}
