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

    // Ende der inneren Klassen

    public Menu(ViewController viewController){
        viewController.draw(this, 0);
        options = new Options(viewController);
        tutorial = new Tutorial(viewController);
    }

    private ViewController viewController;
    Options options;
    Tutorial tutorial;

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

}
