package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.model.Enemy;
import my_project.model.EnemyWave;

public class WaveController extends GraphicalObject /* Macht nicht sonderlich viel Sinn, aber ich brauche update */ {
    private int wave;
    private Enemy[][] array;
    private final ProgramController programController;
    private final ViewController viewController;
    private EnemyWave enemyWave;
    private int powerupCounter;
    private boolean shootLock;
    private boolean clear;

    public WaveController(ProgramController programController, ViewController viewController) {
        this.programController = programController;
        this.viewController = viewController;
        wave = 0;
        powerupCounter = 0;
        array = programController.getArray();
        shootLock = false;
        enemyWave = new EnemyWave(viewController,programController,this);
        viewController.draw(this,GraphicalWindow.GAME_INDEX);
    }

    private boolean checkEmpty() {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 6; y++) {
                if (array[x][y] != null) return false;
            }
        }
        return true;
    }

    public void clear() {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 6; y++) {
                if(array[x][y] != null){
                    viewController.removeDrawable(array[x][y], GraphicalWindow.GAME_INDEX);
                    array[x][y] = null;
                }
            }
        }
        wave = 0;
        powerupCounter = 0;
    }

    @Override
    public void update(double dt) {
        if(checkEmpty() && !clear) {
            if(powerupCounter == 3) {
                programController.createBuff();
                powerupCounter = 0;
            }
            powerupCounter++;
            shootLock = true;
            enemyWave.summonAWave();
            wave++;
        }
    }

    public int getWave() {
        return wave;
    }

    public boolean isShootLock() {
        return shootLock;
    }

    public void setShootLock(boolean shootLock) {
        this.shootLock = shootLock;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }
}