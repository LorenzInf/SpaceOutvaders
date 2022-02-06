package my_project.view;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.model.Enemy;
import my_project.model.EnemyFast;
import my_project.model.Entity;
import my_project.model.Shot;

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

    public void doEnemyMovement(){
        Timer timer = new Timer();
        Visual2DArray<Entity> array = programController.getArray();
        timer.schedule(new TimerTask() {
            private boolean fast = true;
            private final Visual2DArray<Entity> array = programController.getArray();
            @Override
            public void run() {
                for(int x = 1; x <= 11; x++) {
                    for(int y = 7; y >= 0; y -= 2) {
                        if(array.get(x,y) instanceof EnemyFast){
                            doThings(x, y, array);
                        }
                    }
                }
                for(int x = 11; x >= 0; x--) {
                    for (int y = 6; y >= 0; y -= 2) {
                        if(array.get(x,y) instanceof EnemyFast) {
                            if (x == 11) {
                                array.set(array.get(x, y), x, y + 1);
                            } else  {
                                array.set(array.get(x, y), x + 1, y);
                            }
                            array.set(null, x, y);
                        }
                    }
                }
                if(!fast) {
                    for (int x = 1; x <= 11; x++) {
                        for (int y = 7; y >= 0; y -= 2) {
                            if (array.get(x, y) instanceof Enemy && !(array.get(x, y) instanceof EnemyFast)) {
                                doThings(x, y, array);
                            }
                        }
                    }
                    for (int x = 11; x >= 0; x--) {
                        for (int y = 6; y >= 0; y -= 2) {
                            if (array.get(x, y) instanceof Enemy && !(array.get(x, y) instanceof EnemyFast)) {
                                if (x == 11) {
                                    array.set(array.get(x, y), x, y + 1);
                                } else {
                                    array.set(array.get(x, y), x + 1, y);
                                    if(y > 1 && !(array.get(x + 2, y) instanceof Enemy) && programController.getPlayer().getArrayX() == x + 1) {
                                        new Shot(viewController, programController, array.get(x + 1, y).getX() + 60 + 175, array.get(x + 1, y).getY() + 60, 500, true);
                                        SoundController.playSound("shootPlayer");
                                    }
                                }
                                array.set(null, x, y);
                            }
                        }
                    }
                }
                if(viewController.getCurrentSceneIndex() != GraphicalWindow.GAME_INDEX) {
                    timer.cancel();
                    programController.setMoveTimerActive(false);
                }
                fast = !fast;
            }
        }, 0, 500);
    }

    private void doThings(int x, int y, Visual2DArray<Entity> array) {
        if (y == 7) { /* Game Over */ }
        else if (x == 1) {
            array.set(array.get(x, y), 0, y + 1);
        } else {
            array.set(array.get(x, y), x - 1, y);
            if(y > 1 && !(array.get(x - 1, y) instanceof EnemyFast) && !(array.get(x - 2, y) instanceof Enemy) && programController.getPlayer().getArrayX() == x - 1) {
                new Shot(viewController, programController, array.get(x - 1, y).getX() + 60 - 175, array.get(x - 1, y).getY() + 60, 500, true);
                SoundController.playSound("shootPlayer");
            }
        }
        array.set(null, x, y);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
    }
}
