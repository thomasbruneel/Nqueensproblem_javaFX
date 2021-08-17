package sample;



import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Controller implements TaskListener {
	
	private int sizeBord=6;
	
	private int spacing=1000/sizeBord;

	@FXML
	Pane mijnPane;
	
	Button b;
	
	private Tile matrix[][] = new Tile[sizeBord][sizeBord];
	
	private Thread t;
	
	@FXML
    public void initialize() throws IOException, InterruptedException {
		System.out.println(mijnPane.getWidth());
		b=new Button("press me");
		b.setLayoutX(1500);
		mijnPane.getChildren().add(b);
		for(int i=0;i<sizeBord;i++){
			for(int j=0;j<sizeBord;j++){
				Tile tile=new Tile(spacing);
				tile.setTranslateX(j*spacing+10);
				tile.setTranslateY(i*spacing+10);
				mijnPane.getChildren().add(tile);
				matrix[i][j]=tile;
			}
		}
		b.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        try {
					start();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});

	}
	
	

	
	
	
	private void start() throws InterruptedException {
		t=new Thread(() -> {
			Solver taak = new Solver(this,sizeBord);
			try {
				taak.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	});
	t.start();
		
	}



	@Override
	public void drawGreenX(int row, int col) {
		Platform.runLater(() -> {
		matrix[row][col].drawGreenX();
		});
		
	}
	
	@Override
	public void drawRedX(int row, int col) {
		Platform.runLater(() -> {
		matrix[row][col].drawRedX();
		});
		
	}

	@Override
	public void removeX(int row, int col) {
		Platform.runLater(() -> {
			matrix[row][col].removeX();
		});
		
		
	}






	@Override
	public void lightColom(int col) {
		Platform.runLater(() -> {
			for(int i=0;i<sizeBord;i++)
			matrix[i][col].changeColor();
		});
		
	}






	@Override
	public void whiteAllCells() {
		Platform.runLater(() -> {
			for(int i=0;i<sizeBord;i++){
				for(int j=0;j<sizeBord;j++){
					matrix[i][j].whiteColor();
					
				}
			
			}
		});
	}
	
}
