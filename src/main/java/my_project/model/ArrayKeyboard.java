package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.view.Visual2DArray;

import java.awt.*;

public class ArrayKeyboard extends Entity implements Visual2DArray.Animatable {

    private ProgramController programController;
    private String letter;
    private double margin;

    public ArrayKeyboard(String letter, ViewController viewController, ProgramController programController){
        super(viewController, programController);
        margin = 100;
        this.letter = letter;
        viewController.draw(this, GraphicalWindow.ENTER_NAME_INDEX);
    }

    public ArrayKeyboard(String letter, ViewController viewController, ProgramController programController, double margin){
        super(viewController, programController);
        this.programController = programController;
        this.margin = margin;
        this.letter = letter;
        viewController.draw(this, GraphicalWindow.ENTER_NAME_INDEX);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.WHITE);
        drawTool.formatText("Alagard",Font.PLAIN,50);
        drawTool.drawText(x + margin,y + 60, letter);
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
