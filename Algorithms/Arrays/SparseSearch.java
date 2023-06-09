package Algorithms;

public class SparseSearch {
    public static int searchForString(String[] array, String target){
        for(int i=0; i < array.length; i++){
            if(array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int modifiedBinarySearch(String[] array, String target, int low, int high){
        if(low > high){
            return -1;
        }

        int mid = (low + high) / 2;

        if(array[mid] == ""){
            int i = mid - 1;
            int j = mid + 1;
            while(true){
                if(i < low && j > high){
                    return -1;
                }
                if(i >= low && array[i] != ""){
                    mid = i;
                    break;
                }

                else if( j <= high && array[j] != " "){
                    mid = j;
                    break;
                }
                i--;
                j++;
            }
        }

        if(array[mid].equals(target)) return mid;
        else if(array[mid].compareTo(target) > 0) return modifiedBinarySearch(array, target, mid - 1, low);
        else return modifiedBinarySearch(array, target, high, mid + 1);
    }

    public static int searchForStringAgain(String[] array, String target){
        return modifiedBinarySearch(array, target, array.length - 1, 0);
    }
}
