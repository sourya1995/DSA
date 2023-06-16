package Algorithms.DivideConquer;

public class EuclidAlgorithm {
    public static int GCD(int a, int b){
        if(a == 0)
        return b;
        return GCD(b%a, a);
    }

    public static int[] GCD(int a, int b, int x, int y){
        int[] ans = new int[3];

        if(a == 0){
            x = 0;
            y = 1;
            ans[0] = b;
            ans[1] = x;
            ans[2] = y;
            return ans;
        }

        int x1 = x, y1 = y;
        ans = GCD(b%a, a, x1, y1);
        x = ans[2] - (b/a) * ans[1];
        y = ans[1];

        ans[1] = x;
        ans[2] = y;
        return ans;

}
