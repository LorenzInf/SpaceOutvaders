package my_project.view;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;

import java.awt.*;

public class Fade extends GraphicalWindow {
    private boolean fadingIn;
    private boolean fadingOut;
    public double alpha;
    public double delay;
    public double length;
    public int sceneIndex;
    public int sceneToSwitchTo;

    public Fade(ViewController viewController) {
        this.viewController = viewController;
        fadingIn = false;
        fadingOut = false;
        alpha = 0;
    }

    public void fadeIn(int fadeDelay, int fadeLength, int sceneIndex) {
        if (!fadingIn && fadingOut) {
            fadingIn = true;
            alpha = 255;
            delay = fadeDelay;
            length = fadeLength;
            viewController.draw(this,sceneIndex);
        }
    }

    /* TODO fix fadeout
    public void fadeOut(int fadeDelay, int fadeLength, int sceneIndex, int sceneToSwitchTo) {
        if(!fadingIn && !fadingOut) {
            fadingOut = true;
            alpha = 0;
            delay = fadeDelay;
            length = fadeLength;
            viewController.draw(this, sceneIndex);
        }
    }
    */

    @Override
    public void draw(DrawTool drawTool) {
        if (fadingIn) {
            drawTool.setCurrentColor(0,0,0,(int) alpha);
            drawTool.drawFilledRectangle(0,0,Config.WINDOW_WIDTH,Config.WINDOW_HEIGHT);
        }
        /* TODO fix fadeout
        if (fadingOut) {
            drawTool.setCurrentColor(0,0,0,(int) alpha);
            drawTool.drawFilledRectangle(0,0,Config.WINDOW_WIDTH,Config.WINDOW_HEIGHT);
        }
         */
    }

    @Override
    public void update(double dt) {
        if (fadingIn) {
            delay = Math.max(0, delay - dt);
            if (delay == 0) alpha -= dt/length * 255;
            if (alpha <= 0) {
                fadingIn = false;
                viewController.removeDrawable(this);
            }
        }
        /* TODO fix fadeout
        if (fadingOut) {
            alpha = Math.min(255,alpha + (dt/length * 255));
            if (alpha == 255) delay = Math.max(0, delay - dt);
            if (delay == 0) {
                fadingOut = false;
                viewController.showScene(sceneToSwitchTo);
                viewController.removeDrawable(this);
            }
        }
        */
    }
}
