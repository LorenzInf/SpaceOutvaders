package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import java.awt.*;

public class Options extends GraphicalWindow {
    public Options(ViewController viewController) {
        super();
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawFilledRectangle(0,0, Config.WINDOW_WIDTH,Config.WINDOW_HEIGHT);
    }
}