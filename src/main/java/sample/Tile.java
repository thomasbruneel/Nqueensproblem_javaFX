package sample;



import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
	Text text=new Text();
	Rectangle border;
	public Tile(int spacing){
		border=new Rectangle(spacing,spacing);
		border.setFill(null);
		border.setStroke(Color.BLACK);
		text.setFont(Font.font(72));
		getChildren().addAll(border,text);

	}
	
	public void drawGreenX(){
		text.setText("X");
		text.setFill(Color.GREEN);
	}
	
	public void drawRedX(){
		text.setText("X");
		text.setFill(Color.RED);
	}
	public void removeX(){
		text.setText("");
	}

	public void changeColor() {
		border.setFill(Color.YELLOW);
		
	}

	public void whiteColor() {
		border.setFill(Color.WHITE);
		
	}

}
