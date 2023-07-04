package Algorithms.Matrix;

public class TicTacToe {
    public static boolean checkWinPositions(String[] board, Character player){
        for(int i = 0; i < board.length; i++){
            if(board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player){
                return true;
            }

        }

        for(int i = 0; i < board.length; i++){
            if(board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player){
                return true;
            }
        }

        if((board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) || 
        (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player)){
            return true;

        }
        return false;
    }

    public static boolean validTicTacToe(String[] board){
        int xCount = 0;
        int oCount = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i].charAt(j) == 'X')
                    xCount += 1;

                else if(board[i].charAt(j) == 'O'){
                    oCount += 1;
                }
            }
        }

        if(oCount > xCount || xCount - oCount > 1)
            return false;

        if(checkWinPositions(board, 'O')) {
            if(checkWinPositions(board, 'X'))
                return false;

            return oCount == xCount;
        }

        if(checkWinPositions(board, 'X') && xCount != oCount + 1)
            return false;
        return true;
    }

    public static void printTicTacToe(String[] values) {
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.println("\t     |     |");
			System.out.println("\t  " + values[i].charAt(0) + "  |  " + values[i].charAt(1)
					+ "  |  " + values[i].charAt(2));
			if (i < 2)
				System.out.println("\t_____|_____|_____");
			else
				System.out.println("\t     |     |");
		}
		System.out.println();
	}
}
