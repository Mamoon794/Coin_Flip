

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class CoinClatter extends Application implements EventHandler<ActionEvent>{

    Label text, text2;
    int coinflip = 0;
    StringBuffer result;
    int[] amounts = new int[7];

    @Override
    public void start(Stage primaryStage) {

        Stage window = primaryStage;
        window.setTitle("Coin Clatter");

        Button roll = new Button("flip coins");
        roll.setOnAction(this);

        text = new Label("Press the flip coin button to flip the two coins");
        text.setFont(new Font("Dialog", 15));
        text2 = new Label("Coin flip number: " + coinflip);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(text, roll, text2);

        Scene scene1 = new Scene(layout, 310, 100);

        window.setScene(scene1);
        window.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        result = new StringBuffer("");
        int randomnum = (int) (Math.random()*2+1);
        int randomnum2 = (int) (Math.random()*2+1);
        int randomnum3 = (int) (Math.random()*2+1);
        int randomnum4 = (int) (Math.random()*2+1);

        convert(randomnum);
        convert(randomnum2);

        if(result.toString().equals(" T T")) {
            convert(randomnum3);
            convert(randomnum4);
        }

        coinflip ++;
        addAmount();
        text.setText("Your coin flip results were" + result);
        text2.setText("Coin flip number: " + coinflip);



    }

    public void convert(int num) {

        if (num == 1)
            result.append(" H");

        if(num == 2)
            result.append(" T");
    }

    public void addAmount() {
        String temp = result.toString();
        if(temp.equals(" H H"))
            amounts[0] += 1;

        if(temp.equals(" H T"))
            amounts[1] += 1;

        if(temp.equals(" T H"))
            amounts[2] += 1;

        if(temp.equals(" T T H H"))
            amounts[3] += 1;

        if(temp.equals(" T T H T"))
            amounts[4] += 1;

        if(temp.equals(" T T T H"))
            amounts[5] += 1;

        if(temp.equals(" T T T T"))
            amounts[6] += 1;

    }

}

