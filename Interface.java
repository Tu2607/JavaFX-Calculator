import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Interface extends Application{
    static public void main(String Argv[]){
        launch();
    }

	@Override
	public void start(Stage primaryStage) throws Exception { 
        primaryStage.setTitle("Calculator"); 
        primaryStage.setResizable(false); //Can't resize this bitch

        GridPane mainPane = new GridPane(); 

        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(10);
        layout.getColumnConstraints().add(col);
        
        col = new ColumnConstraints();
        col.setPercentWidth(10);
        layout.getColumnConstraints().add(col);

        col = new ColumnConstraints();
        col.setPercentWidth(10);
        layout.getColumnConstraints().add(col);

        col = new ColumnConstraints();
        col.setPercentWidth(10);
        layout.getColumnConstraints().add(col);

        TextField pad = new TextField();
        pad.autosize();
        mainPane.add(pad, 0, 0);

        Button buttons[] = new Button[10];
        for(int i = 0; i < 10; ++i){
            buttons[i]  = new Button(Integer.toString(i)); 
            buttons[i].setPrefSize(70, 70);
        }
        Button add = new Button("+");
        Button sub = new Button("-");
        Button mul = new Button("*");
        Button div = new Button("/");

        //Numbers pad
        layout.add(buttons[0], 1, 4);
        layout.add(buttons[1], 0, 3);
        layout.add(buttons[2], 1, 3);
        layout.add(buttons[3], 2, 3);
        layout.add(buttons[4], 0, 2);
        layout.add(buttons[5], 1, 2);
        layout.add(buttons[6], 2, 2);
        layout.add(buttons[7], 0, 1);
        layout.add(buttons[8], 1, 1);
        layout.add(buttons[9], 2, 1);

        //Operation pad
        layout.add(add, 3, 0);
        add.setPrefSize(70, 70);
        layout.add(sub, 3, 1);
        sub.setPrefSize(70, 70);
        layout.add(mul, 3, 2);
        mul.setPrefSize(70, 70);
        layout.add(div, 3, 3);
        div.setPrefSize(70, 70);

        layout.setAlignment(Pos.CENTER);
        layout.setPrefSize(300, 400);

        mainPane.add(layout,0,1);

        Scene scene = new Scene(mainPane, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

	}
}