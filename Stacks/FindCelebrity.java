package Stacks;

public class FindCelebrity {

    private static boolean aqStatus(int[][]party, int x, int y){
        if(party[x][y]== 1) return true;
        return false;
    }

    public static int findCelebrity(int[][] party, int numPeople){
        Stack<Integer> stack = new Stack<>(numPeople);
        int celebrity = -1;

        for(int i = 0; i < numPeople; i++){
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int x = stack.pop();
            if(stack.isEmpty()){
                celebrity = x;
                break;
            }

            int y = stack.pop();
            if(aqStatus(party, x, y)){
                stack.push(y);
            } else stack.push(x);
        }

        for(int j = 0; j < numPeople; j++) {
            if (celebrity != j && (aqStatus(party, celebrity, j)) || !(aqStatus(party, j, celebrity))) return -1;
        }
        return celebrity;


    }
    
}
