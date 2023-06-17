public class isPrime{
    public static boolean isPrimeNumber(int num, int i){

        if(num < 2) return false;
        else if (i == 1) return true;
        else if (num % i == 0) return false;
        else return isPrimeNumber(num, i-1);
    }
}