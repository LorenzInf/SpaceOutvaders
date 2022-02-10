package my_project.model;

import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import my_project.control.WaveController;

import java.util.Random;

public class EnemyWave {

    private final ViewController viewController;
    private final ProgramController programController;
    private final double difficultyN11, difficultyF11, difficultyS11, difficultyB11, difficultyN6B5, difficultyN11B11,
            difficultyS11N11, difficultyI11, difficultyS11I11, difficultyB11F11, difficultyS11N22, difficultyI12B10F11,
            difficultyI11S11F11, difficultyS22B11, difficultyF22I11, difficultyS22B11I11;
    private double difficultyCurrent;
    private final Enemy[][] array;
    private final WaveController waveController;

    public EnemyWave(ViewController viewController, ProgramController programController, WaveController waveController) {
        this.viewController = viewController;
        this.programController = programController;
        this.waveController = waveController;
        array = programController.getArray();
        difficultyN11 = 0.25;
        difficultyF11 = 0.5;
        difficultyS11 = 0.75;
        difficultyB11 = 0.99;
        difficultyN6B5 = 1.99;
        difficultyN11B11 = 2.5;
        difficultyS11N11 = 2.99;
        difficultyI11 = 3.33;
        difficultyS11I11 = 3.66;
        difficultyB11F11 = 3.99;
        difficultyS11N22 = 4.5;
        difficultyI12B10F11 = 4.99;
        difficultyI11S11F11 = 5.5;
        difficultyS22B11 = 5.99;
        difficultyF22I11 = 6.5;
        difficultyS22B11I11 = 6.99;
    }


    /**
     * Based on {@code difficultyCurrent} a random wave from one of the methods below is picked. {@code difficultyCurrent} is the same as the amount of waves you have gone through, making the game harder the further you go
     */
    public void summonAWave() {
        difficultyCurrent = waveController.getWave();
        double random = new Random().nextDouble() * difficultyCurrent + (difficultyCurrent) / 20;
        if(difficultyS22B11I11 < random) summonShield22Burst11Instant11();
        else if(difficultyF22I11 < random) summonFast22Instant11();
        else if(difficultyS22B11 < random) summonShield22Burst11();
        else if(difficultyI11S11F11 < random) summonInstant11Shield11Fast11();
        else if(difficultyI12B10F11 < random) summonInstant12Burst10Fast11();
        else if(difficultyS11N22 < random) summonShield11Normal22();
        else if(difficultyB11F11 < random) summonBurst11Fast11();
        else if(difficultyS11I11 < random) summonShield11Instant11();
        else if(difficultyI11 < random) summonInstant11();
        else if(difficultyS11N11 < random) summonShield11Normal11();
        else if(difficultyN11B11 < random) summonNormal11Burst11();
        else if(difficultyN6B5 < random) summonNormal6Burst5();
        else if(difficultyB11 < random) summonBurst11();
        else if(difficultyS11 < random) summonShield11();
        else if(difficultyF11 < random) summonFast11();
        else if(difficultyN11 < random) summonNormal11();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 6; j++) {
                if (array[i][j] != null) {
                    array[i][j].setMoving(true);
                }
            }
        }
    }

    private void summonNormal11() {
        for(int i = 0; i < 11; i++) {
            array[i][0] = new EnemyNormal(viewController, programController,i,0);
        }
    }

    private void summonFast11() {
        for(int i = 0; i < 11; i ++) {
            array[i][0] = new EnemyFast(viewController, programController,i,0);
        }
    }

    private void summonShield11() {
        for(int i = 0; i < 11; i++) {
            array[i][0] = new EnemyShield(viewController, programController,i,0);
        }
    }

    private void summonBurst11() {
        for(int i = 0; i < 11; i++) {
            array[i][0] = new EnemyShield(viewController, programController,i,0);
        }
    }

    private void summonNormal6Burst5() {
        for(int i = 0; i < 11; i += 2) {
            array[i][0] = new EnemyNormal(viewController, programController,i,0);
        }
        for(int i = 1; i < 11; i += 2) {
            array[i][0] = new EnemyBurst(viewController, programController,i,0);
        }
    }

    private void summonNormal22() {
        for (int i = 0; i < 11; i++) {
            array[i][1] = new EnemyNormal(viewController, programController,i,-1);
        }
        summonNormal11();
    }

    private void summonNormal6Instant5() {
        for(int i = 1; i < 11; i += 2) {
            array[i][0] = new EnemyInstant(viewController, programController,i,0);
        }
        for(int i = 0; i < 11; i += 2) {
            array[i][0] = new EnemyNormal(viewController, programController,i,0);
        }
    }

    private void summonNormal11Burst11() {
        summonNormal6Burst5();
        for(int i = 1; i < 11; i += 2) {
            array[i][1] = new EnemyNormal(viewController, programController,i,-1);
        }
        for(int i = 0; i < 11; i += 2) {
            array[i][1] = new EnemyBurst(viewController, programController,i,-1);
        }
    }

    private void summonShield11Normal11() {
        for(int i = 0; i < 11; i++) {
            array[i][0] = new EnemyNormal(viewController, programController,i,-1);
        }
        for(int i = 0; i < 11; i++) {
            array[i][1] = new EnemyShield(viewController, programController,i,0);
        }
    }

    private void summonInstant11() {
        for(int i = 0; i < 11; i++) {
            array[i][0] = new EnemyInstant(viewController, programController,i,0);
        }
    }

    private void summonShield11Instant11() {
        for(int i = 0; i < 11; i++) {
            array[i][0] = new EnemyInstant(viewController, programController,i,-1);
        }
        for(int i = 0; i < 11; i++) {
            array[i][1] = new EnemyShield(viewController, programController,i,0);
        }
    }

    private void summonBurst11Fast11() {
        for(int i = 0; i < 11; i++) {
            array[i][0] = new EnemyBurst(viewController, programController,i,-1);
        }
        for(int i = 0; i < 11; i++) {
            array[i][1] = new EnemyFast(viewController, programController,i,0);
        }
    }

    private void summonShield11Normal22() {
        summonShield11Normal11();
        for(int i = 0; i < 11; i++) {
            array[i][3] = new EnemyNormal(viewController, programController,i,-2);
        }
    }

    private void summonInstant12Burst10Fast11() {
        summonFast11();
        for (int i = 0; i < 11; i += 2) {
            array[i][1] = new EnemyInstant(viewController, programController,i,-1);
        }
        for (int i = 0; i < 11; i += 2) {
            array[i][2] = new EnemyInstant(viewController, programController,i,-2);
        }
        for (int i = 1; i < 11; i += 2) {
            array[i][1] = new EnemyBurst(viewController, programController,i,-1);
        }
        for (int i = 1; i < 11; i += 2) {
            array[i][2] = new EnemyBurst(viewController, programController,i,-2);
        }
    }

    private void summonInstant11Shield11Fast11() {
        summonFast11();
        for(int i = 0; i < 11; i++) {
            array[i][1] = new EnemyShield(viewController, programController,i,-1);
        }
        for(int i = 0; i < 11; i++) {
            array[i][3] = new EnemyInstant(viewController, programController,i,-2);
        }
    }

    private void summonShield22Burst11() {
        summonShield11();
        for (int i = 0; i < 11; i++) {
            array[i][1] = new EnemyShield(viewController, programController,i,-1);
        }
        for (int i = 0; i < 11; i++) {
            array[i][2] = new EnemyBurst(viewController, programController,i,-2);
        }
    }

    private void summonFast22Instant11() {
        summonFast11();
        for(int i = 0; i < 11; i ++) {
            array[i][1] = new EnemyFast(viewController, programController,i,-1);
        }
        for(int i = 0; i < 11; i ++) {
            array[i][2] = new EnemyInstant(viewController, programController,i,-2);
        }
    }

    private void summonShield22Burst11Instant11() {
        summonShield11();
        for(int i = 0; i < 11; i++) {
            array[i][1] = new EnemyShield(viewController, programController,i,1);
        }
        for(int i = 0; i < 11; i++) {
            array[i][2] = new EnemyBurst(viewController, programController,i,-1);
        }
        for(int i = 0; i < 11; i++) {
            array[i][3] = new EnemyInstant(viewController, programController,i,-2);
        }
    }
}