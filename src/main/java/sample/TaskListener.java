package sample;



public interface TaskListener {
	
	void drawGreenX(int row, int col);
	
	void drawRedX(int row, int col);
	
	void removeX(int row, int col);
	
	void lightColom(int col);
	
	void whiteAllCells();

}
