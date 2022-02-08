package my_project.model;

import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import my_project.view.Game;
import my_project.view.Visual2DArray;

import java.util.Random;

public class EnemyWave {

    private final ViewController viewController;
    private final ProgramController programController;
    private final double difficultyN22, difficultyM11, difficultyF6, difficultyM22;
    private double difficultyCurrent;
    private final Enemy[][] array;

    public EnemyWave(ViewController viewController, ProgramController programController, Game game) {
        this.viewController = viewController;
        this.programController = programController;
        array = programController.getArray();
        difficultyCurrent = 1.0;
        difficultyM11 = 1.33;
        difficultyN22 = 1.66;
        difficultyF6 = 2.0;
        difficultyM22 = 2.5;
    }

    public void summonAWave() {
        double random = new Random().nextDouble() * difficultyCurrent;
    }

    public void summon() {
        for (int i = 0; i < 11; i++) {
            array[i][0] = new EnemyBurst(viewController, programController, true, i, 0);
        }
        for (int i = 0; i < 11; i++) {
            array[i][0].setMoving(true);
        }
    }

    /*private void summonNormal11() {
        for(int i = 1; i <= 11; i++) {
            array.set(new EnemyNormal(viewController, programController,true), i, 2);
        }
    }

    private void summonFast11() {
        for(int i = 1; i <= 11; i ++) {
            array.set(new EnemyFast(viewController, programController,true), i, 2);
        }
    }

    private void summonShield11() {
        for(int i = 1; i <= 11; i++) {
            array.set(new EnemyShield(viewController, programController,true), i, 2);
        }
    }

    private void summonNormal6Burst6() {
        for(int i = 1; i <= 11; i += 2) {
            array.set(new EnemyNormal(viewController, programController,true), i, 2);
        }
        for(int i = 2; i <= 11; i += 2) {
            array.set(new EnemyBurst(viewController, programController,true), i, 2);
        }
    }

    private void summonNormal22() {
        for (int i = 1; i <= 11; i++) {
            array.set(new EnemyNormal(viewController, programController), i, 1);
        }
        summonNormal11();
    }

    private void summonNormal11Burst11() {
        summonNormal6Burst6();
        for(int i = 2; i <= 11; i += 2) {
            array.set(new EnemyNormal(viewController, programController), i, 1);
        }
        for(int i = 1; i <= 11; i += 2) {
            array.set(new EnemyBurst(viewController, programController), i, 1);
        }
    }

    private void summonShield11Normal11(){
        for(int i = 1; i < 11; i++) {
            array.set(new EnemyNormal(viewController, programController), i, 0);
        }
        for(int i = 1; i < 11; i++) {
            array.set(new EnemyShield(viewController, programController), i, 1);
        }
    }*/
}