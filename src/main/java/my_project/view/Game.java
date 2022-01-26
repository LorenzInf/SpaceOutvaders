package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.model.Enemy;
import my_project.model.PlayerLife;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends GraphicalWindow {

    private BufferedImage[] images;

    public Game(ViewController viewController, ProgramController programController) {
        super();
        this.viewController = viewController;
        this.programController = programController;
        viewController.createScene();
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt weil sonst die Images neu geladen werden
                createImage("src/main/resources/graphic/maingame_blank.png")
        };
    }

    public void EnemyMovement(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int x = 7; x > 0; x--) {
                    for(int y = 10; y > 0; y--) {
                        if(programController.getArray().get(x,y) instanceof Enemy){
                            //TODO :)
                        }
                    }
                }
                if(viewController.getCurrentSceneIndex() != GraphicalWindow.GAME_INDEX){
                    timer.cancel();
                    programController.setMoveTimerActive(false);
                }
            }
        }, 0, 1000);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
    }
}
