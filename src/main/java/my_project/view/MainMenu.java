package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.Graph;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;

import java.awt.*;

public class MainMenu extends GraphicalWindow {

    public MainMenu(ViewController viewController) {
        super();
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.white);
        drawTool.formatText("Comic Sans MS",Font.BOLD,20);
        drawTool.drawText(540,900,"OMG DAS BESTE SPIEL DER WELT: SPACE OUTVADERS");
        drawTool.drawText(150,220, "Start");
        drawTool.drawText(475,220, "Ende");
        drawTool.drawRectangle(450,200,150,100);
        drawTool.drawText(775,220, "Optionen");
        drawTool.drawRectangle(750,200,150,100);
        // ToDO: Button wird nicht Rot
        if(getButtonIndex() == 1){
            drawTool.setCurrentColor(Color.RED);
            drawTool.drawRectangle(125,200,150,100);
        }
    }
}
