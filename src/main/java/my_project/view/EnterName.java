package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.InputManagerEnterName;
import my_project.control.ProgramController;
import my_project.model.PlayerLife;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnterName extends GraphicalWindow implements VisualList.AnimableList {

    private ProgramController programController;
    private BufferedImage[] images;
    private String name;
    private int letterNumber;
    private int score;

    public EnterName(ViewController viewController, ProgramController programController){
        super();
        this.programController = programController;
        name = "";
        viewController.createScene();
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/enterYourName_screen.png"),//0
        };
    }

    public EnterName(String name, int score, ViewController viewController, ProgramController programController){
        super();
        this.programController = programController;
        this.name = name;
        this.score = score;
        viewController.createScene();
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/enterYourName_screen.png"),//0
        };
    }

    public void attachToName(String string){
        name += string + "";
        letterNumber++;
        score = programController.getScore();
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,0,0,255); //Bitte nicht fragen, Backgroundcolour hat mich gemobbt
        drawTool.drawFilledRectangle(0,0,1920,1080+29);
        drawTool.drawImage(images[0], 0 ,0);
        drawTool.setCurrentColor(Color.WHITE);
        drawTool.formatText("Alagard",0,80);
        drawTool.drawText(565,610, name);
    }

    public int getLetterNumber() {
        return letterNumber;
    }

    public void setLetterNumber(int letterNumber) {
        this.letterNumber = letterNumber;
    }

    public String getName() {
        return name;
    }

    public int getScore(){
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean tryToDelete() {
        return false;
    }


}
