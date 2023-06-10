package Algorithms.Greedy;

public class PasswordLargestNumber {
    public static int findSumOfDigits(int num){
        int sum = 0;
        while(num != 0){
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void findLargestNumber(int numberOfDigits, int sumOfDigits) {
        int max = 0;
        int startRange = (int) Math.pow(10, (numberOfDigits - 1));
        int endRange = (int) Math.pow(10, numberOfDigits);

        if(sumOfDigits == 0){
            if(numberOfDigits == 1){
                System.out.println("largest number is:" + 0);
            }else
                System.out.println("Largest number is not possible");
            return;
        }

        if(sumOfDigits > 9 * numberOfDigits) {
            System.out.println("Largest number is not possible");
            return;
        }

        while(startRange < endRange){
            if(findSumOfDigits(startRange) == sumOfDigits){
                if(max < startRange)
                 max = startRange;
            }
            startRange++;
        }
        System.out.println("Largest number is" + max);
    }

    public static void findLargestNumberGreedy(int numberOfDigits, int sumOfDigits){
        int[] result = new int[numberOfDigits];
        if(sumOfDigits == 0){
            if(numberOfDigits == 1){
                System.out.println(0);
            } else {
                System.out.println("None");
            }
            return;
    }

    if(sumOfDigits > 9 * numberOfDigits){
        System.out.println("None");
        return;
    }

    for(int i =0; i < numberOfDigits; i++){
        if(sumOfDigits >= 9){
            result[i] = 9;
            sumOfDigits -= 9;
        }

        else{
            result[i] = sumOfDigits;
            sumOfDigits = 0;
        }
    }
    for(int i = 0; i < numberOfDigits; i++){
        System.out.println(result[i]);
    }


}
