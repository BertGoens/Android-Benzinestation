package util;

/* Created by Bert Goens */
public final class RoundToDouble {
    public static double roundToDouble(double r) {
        double roundOff = (double) Math.round(r * 100) / 100;
        return roundOff;
    }
}
