package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.view.Visual2DArray;

import java.awt.*;

public class ArrayKeyboard extends Entity implements Visual2DArray.Animatable {

    private ArrayKeyboard arrayKeyboard;
    private String letter;




    public ArrayKeyboard(String letter, ViewController viewController, ProgramController programController){
        super(viewController, programController);
        this.letter = letter;
        viewController.draw(this);
    }
    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.WHITE);
        drawTool.formatText("Alagard",Font.PLAIN,50);
        drawTool.drawText(x + 100,y + 60,letter);


    }
    @Override
    public void fadeIn() {

    }

    @Override
    public void fadeOut() {

    }


    public String getLetter() {
        return letter;
    }
}
