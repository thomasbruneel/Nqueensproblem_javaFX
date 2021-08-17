package sample;



public class Solver {
	int N;
	
	private final TaskListener listener;
	
	private int time=350;
	
	public Solver(TaskListener listener, int sizeBord) {
		this.N=sizeBord;
		this.listener=listener;
	}

	public boolean isSafe(int board[][], int row, int col) {
		int i, j;
		for (i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		for (i = row, j = col; j >= 0 && i < N; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

	public boolean theBoardSolver(int board[][], int col) throws InterruptedException {
		if (col >= N)
			return true;
		listener.lightColom(col);
		for (int i = 0; i < N; i++) {
			
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				listener.drawGreenX(i,col);
				Thread.sleep(time);
				listener.whiteAllCells();
				if (theBoardSolver(board, col + 1))
					return true;
				listener.lightColom(col);
				if((N-1)==i)
					Thread.sleep(time);
				board[i][col] = 0;
				listener.removeX(i, col);

			}
			else{
				listener.drawRedX(i,col);
				Thread.sleep(time);
				listener.removeX(i, col);
			}

		}
		listener.whiteAllCells();
		Thread.sleep(time);
		return false;
	}

	public void start() throws InterruptedException {
		int[][] board = new int[N][N];
		theBoardSolver(board,0);
		
	}
}
