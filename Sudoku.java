package Sudoku;
public class Sudoku {
	static int size=9;
	static int empty=0;
	public static void main (String a[]){
	System.out.println("Printing incomplete sudoku!");
	int board[][] = 
		{			
			{0,1,9	,0,0,2	,0,0,0},
			{4,7,0	,6,9,0	,0,0,1},
			{0,0,0	,4,0,0	,0,9,0},

			{8,9,4	,5,0,7	,0,0,0},
			{0,0,0	,0,0,0	,0,0,0},
			{0,0,0	,2,0,1	,9,5,8},

			{0,5,0	,0,0,6	,0,0,0},
			{6,0,0	,0,2,8	,0,7,9},
			{0,0,0	,1,0,0	,8,6,0}
		};
	printSudokuBoard(board);
	if(solve(board)){
		System.out.println("Printing solved Sudoku Grid -");
		printSudokuBoard(board);	
	}
	else{
		System.out.println("Unsolvable sudoku -");
	}
	
		
	}

	static boolean solve(int board[][]) {
		for(int i = 0;i<size;i++){
			for(int j = 0;j<size;j++){
				if(board[i][j]==empty){
					for(int k=1;k<=9;k++){
						if(allGood(board, i,j,k)){
							board[i][j] = k;
							if(solve(board)){
								return true;
							}else{
								board[i][j]=empty;
							}
						}
					}
					return false;
					
				}
			}
			}
		return true;
	}

	private static boolean allGood(int [][] board,int i, int j, int k) {
		if(notInRow(board,k,i) && notInCol(board,j,k) && notInBox(board,i,j,k))
			return true;
		return false;
	}

	private static boolean notInCol(int[][] board,int col, int k) {
		for(int j=0;j<9;j++){
			if(board[col][j]==k)
				//found in column
				return false;
		}
		return true;
	}

	private static boolean notInBox(int[][] board, int i, int j, int k) {
		int row = i-i%3;
		int col = j-j%3;
		for(int a=row;a<row+3;a++){
			for(int b =col;b<col+3;b++){
				if(board[row][col]==k)	
					return false;
			}
		}
		return true;
	}

	private static boolean notInRow(int[][] board, int k, int row) {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++){
			if(board[row][i]==k)
				return false;
		}
		return true;
	}

	private static void printSudokuBoard(int[][] board) 
	{
		System.out.println("--------------------------");
		for (int i=0;i<board.length;i++){
			for (int j=0;j<board.length;j++)
			{
					System.out.print(" "+board[i][j]);
					if((j+1)%3==0)
						System.out.print(" | ");
			}
			System.out.print("\n");
			if((i+1)%3==0){
				System.out.println("--------------------------");
			}
		}
	}
}
