package Level2;

public class UnitConvertorThree {
    public static double convertFarhenheitToCelsius(double f) { return (f - 32) * 5 / 9; }
    public static double convertCelsiusToFarhenheit(double c) { return (c * 9 / 5) + 32; }
    public static double convertPoundsToKilograms(double p) { return p * 0.453592; }
    public static double convertKilogramsToPounds(double k) { return k * 2.20462; }
    public static double convertGallonsToLiters(double g) { return g * 3.78541; }
    public static double convertLitersToGallons(double l) { return l * 0.264172; }
    public static void main(String[] args) {
        System.out.println("100 F to C: " + convertFarhenheitToCelsius(100));
        System.out.println("0 C to F: " + convertCelsiusToFarhenheit(0));
        System.out.println("10 pounds to kg: " + convertPoundsToKilograms(10));
        System.out.println("10 kg to pounds: " + convertKilogramsToPounds(10));
        System.out.println("10 gallons to liters: " + convertGallonsToLiters(10));
        System.out.println("10 liters to gallons: " + convertLitersToGallons(10));
    }
}
