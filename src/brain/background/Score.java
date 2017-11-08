package brain.background;

import bases.GameObject;
import java.awt.*;

public class Score extends GameObject {

    TextField textField = new TextField();

    public static int score;
    public Score(){
        score = 0;
        textField.setText("Hello");
    }
    public static void addScore(int num){
        score+=num;
    }
}
