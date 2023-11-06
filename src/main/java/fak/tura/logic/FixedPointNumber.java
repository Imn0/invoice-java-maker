package fak.tura.logic;

public class FixedPointNumber {
    private int number;

    public FixedPointNumber(int number) {
        this.number = number;
    }
    public FixedPointNumber(FixedPointNumber fixedPointNumber) {
        this.number = fixedPointNumber.number;
    }
    public void add(FixedPointNumber fixedPointNumber) {
        this.number += fixedPointNumber.number;
    }
    public void mul(FixedPointNumber fixedPointNumber) {
        this.number *= fixedPointNumber.number;
        this.number = number/100;
    }

    public boolean isEqual(FixedPointNumber fixedPointNumber) {
        return this.number == fixedPointNumber.number;
    }

    @Override
    public String toString() throws NumberFormatException {
        if (number < 0) {
            throw new NumberFormatException("nie można przekonwertować ujemnej liczby");
        }

        String tmp = Integer.toString(number);
        int desiredLength = 3;
        if (tmp.length() < desiredLength) {
            tmp = "0" + tmp;
        }
        if (tmp.length() < desiredLength) {
            tmp = "0" + tmp;
        }
        return tmp.substring(0, tmp.length() - 2) + "." + tmp.substring(tmp.length() - 2);
    }
    public FixedPointNumber (final String str) throws NumberFormatException {
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
            decimalPart = Character.getNumericValue(ulamek.charAt(0)) * 10 + Character.getNumericValue(ulamek.charAt(1));
        } catch (Exception e) {
            throw new NumberFormatException("niepoprawna wartość całkowita");
        }
        if (decimalPart < 0 || decimalPart > 99) {
            throw new NumberFormatException("niepoprawna wartość ułamkowa");
        }

        this.number = integerPart* 100 + decimalPart;
    }
}
