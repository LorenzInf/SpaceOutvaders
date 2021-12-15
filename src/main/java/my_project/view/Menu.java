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

    private ViewController viewController;
    Options options;
    Tutorial tutorial;
    Game game;
    Leaderboard leaderboard;

    public Menu(ViewController viewController){
        viewController.draw(this, 0);
        options = new Options(viewController);
        tutorial = new Tutorial(viewController);
        game = new Game(viewController);
        leaderboard = new Leaderboard(viewController);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.white);
        drawTool.formatText("Comic Sans MS",Font.BOLD,20);
        drawTool.drawText(540,900,"OMG DAS BESTE SPIEL DER WELT: SPACE OUTVADERS");
        drawTool.drawText(150,220, "Start");
        drawTool.drawRectangle(125,200,150,100);
        drawTool.drawText(475,220, "Ende");
        drawTool.drawRectangle(450,200,150,100);
        drawTool.drawText(775,220, "Optionen");
        drawTool.drawRectangle(750,200,150,100);
    }
}
