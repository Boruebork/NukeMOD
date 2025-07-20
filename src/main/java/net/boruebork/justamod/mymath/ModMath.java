package net.boruebork.justamod.mymath;

public class ModMath {
    public static double degreesToRadians(double degrees){
        return Math.PI/180 * (degrees % 360);
    }
    public static double radiansToDegrees(double radians){
        return Math.toDegrees(radians);
    }
    public static double roundTo(int percision, double number){
        return (double) Math.round(number * percision) / percision;
    }
    public static double sin(double degrees){
        return Math.sin(degreesToRadians(degrees));
    }
    public static double cos(double degrees){
        return Math.cos(degreesToRadians(degrees));
    }
    public static double tan(double degrees){
        return Math.tan(degreesToRadians(degrees));
    }
    public static double ctan(double degrees){
        return 1 / Math.tan(degreesToRadians(degrees));
    }

}
