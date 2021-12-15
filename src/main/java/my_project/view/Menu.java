package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import java.awt.*;

public class Menu extends GraphicalObject {

    // Innere Klassen für die verschiedenen Fenster
    private static class Options extends GraphicalObject {
        public Options(ViewController viewController){
            viewController.draw(this, 1);
        }

        @Override
        public void draw(DrawTool drawTool){
            //Optionen Zeug
        }
    }

    private static class Tutorial extends GraphicalObject {
        public Tutorial(ViewController viewController) {
            viewController.draw(this, 2);
        }

        @Override
        public void draw(DrawTool drawTool) {
            //Tutorial Zeug
        }
    }

    private static class Game extends GraphicalObject {
        public Game(ViewController viewController) {
            viewController.draw(this,3);
        }

        @Override
        public void draw(DrawTool drawTool) {
            //Game zeug
        }
    }

    private static class Leaderboard extends GraphicalObject {
        public Leaderboard(ViewController viewController) {
            viewController.draw(this,4);
        }

        @Override
        public void draw(DrawTool drawTool) {
            //Leaderboard zeug
        }
    }
    // Ende der inneren Klassen

    private int buttonIndex;

    public Menu(ViewController viewController){
        buttonIndex = 1;
        viewController.draw(this, 0);
        this.viewController = viewController;
        options = new Options(viewController);
        tutorial = new Tutorial(viewController);
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
    }

    private ViewController viewController;
    private Options options;
    private Tutorial tutorial;

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.white);
        drawTool.formatText("Comic Sans",Font.BOLD,20);
        drawTool.drawText(540,900,"OMG DAS BESTE SPIEL DER WELT: SPACE OUTVADERS");
        drawTool.drawText(150,220, "Start");
        drawTool.drawRectangle(125,200,150,100);
        drawTool.drawText(475,220, "Ende");
        drawTool.drawRectangle(450,200,150,100);
        drawTool.drawText(775,220, "Optionen");
        drawTool.drawRectangle(750,200,150,100);
    }

     public void switchScene(){
        switch(getButtonIndex()){
            case 1 -> viewController.showScene(1);
            case 2 -> viewController.showScene(2);
            case 3 -> viewController.showScene(3);
            case 4 -> viewController.showScene(4);
        }
     }

     public int getButtonIndex(){
        return buttonIndex;
     }

    public void setButtonIndex(int buttonIndex) {
        this.buttonIndex = buttonIndex;
    }
}
