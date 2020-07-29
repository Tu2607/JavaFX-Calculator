import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    operation<Float> fOp;
    operation<Integer> iOp;

	@Override
	public void start(Stage primaryStage) throws Exception { 
        primaryStage.setTitle("Calculator"); 
        primaryStage.setResizable(false); //Can't resize this bitch

        GridPane mainPane = new GridPane(); 
        mainPane.setHgap(10);

        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(10);
        layout.getColumnConstraints().add(col);
        
        for(int i = 0; i < 3; ++i){
            col = new ColumnConstraints();
            col.setPercentWidth(10);
            layout.getColumnConstraints().add(col);
        }

        TextField pad = new TextField();
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
        Button sign = new Button("+/-");
        Button dot = new Button (".");
        Button C = new Button("C");
        Button CE = new Button("CE");
        Button equal = new Button("=");

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
        layout.add(sign, 0, 4);
        sign.setPrefSize(70, 70);
        layout.add(dot, 2, 4);
        dot.setPrefSize(70, 70);
        layout.add(C, 0, 0);
        C.setPrefSize(70, 70);
        layout.add(CE, 1, 0);
        CE.setPrefSize(70, 70);
        layout.add(equal,3,4);
        equal.setPrefSize(70, 70);

        //Setting up number buttons
        for(int i = 0; i < 10; ++i){
            Integer a = i;
            buttons[i].setOnAction(e -> {
                String cur = pad.getText();
                pad.setText(cur + Integer.toString(a));
            });
        }

        //For decimal
        dot.setOnAction(e -> {
            String cur = pad.getText();
            if(cur.isEmpty()){ //Check this part abit more
                pad.setText("0.");
            } else {
                pad.setText(cur + ".");
            }
        });

        //Signed number
        sign.setOnAction(e -> {
            String cur = pad.getText();
            if(cur.isEmpty()){}
            else if(cur.charAt(0) == '-'){ //Debug this part here
                pad.setText(cur.substring(1));
            }
            else{
                pad.setText("-" + cur);
            }
        });

        C.setOnAction(e -> {
            if(pad.getText().isEmpty()){ }
            else {
                String cur = pad.getText();
                cur = cur.substring(0, cur.length() - 1);
                pad.setText(cur);
            }
        });

        CE.setOnAction(e -> {
            if(pad.getText().isEmpty()){ }
            else{
                pad.setText("");
            }
        });
    
        /*Begin of operation code */

        add.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                String op1 = pad.getText();
                if(op1.contains(".")){
                    Float num = Float.parseFloat(op1);
                    fOp = new operation<Float>(num, 1);
                } else {
                    Integer num = Integer.parseInt(op1);
                    iOp = new operation<Integer>(num,1);
                }
           }
        });



        layout.setAlignment(Pos.CENTER);
        layout.setPrefSize(400, 500);

        mainPane.add(layout,0,1);
        mainPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private operation Calculate(operation toSet){
        return toSet;
    }
}