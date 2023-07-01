package Algorithms.Math;

public class RectangleOverlap {
    public static Boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        Boolean xRec1 = rec1[0] < rec2[2];
        Boolean yRec1 = rec1[1] < rec2[3];

        Boolean xRec2 = rec2[0] < rec1[2];
        Boolean yRec2 = rec2[1] < rec1[3];

        return ((xRec1 && yRec1) && (xRec2 && yRec2));
    }
}
