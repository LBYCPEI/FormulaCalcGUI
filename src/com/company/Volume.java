package com.company;

public class Volume {

    public static double computeVolume(double length, double width, double height) {
        return (length * width * height);
    }

    public static double computeLength(double width, double height, double volume) {
        return (volume / (width * height));
    }

    public static double computeWidth(double height, double volume, double length) {
        return (volume / (length * height));
    }

    public static double computeHeight(double volume, double length, double width) {
        return (volume / (length * width));
    }
}
