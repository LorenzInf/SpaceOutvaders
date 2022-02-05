package my_project.model;

import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import java.util.Random;

public class EnemyWave{

    private final ViewController viewController;
    private final ProgramController programController;
    private final int difficultyW1, difficultyW2, difficultyW3;
    private int difficultyCurrent;

    public EnemyWave(ViewController viewController, ProgramController programController){
        this.viewController = viewController;
        this.programController = programController;
        difficultyCurrent = 99;
        difficultyW1 = 100;
        difficultyW2 = 110;
        difficultyW3 = 120;
    }

    public void summonAWave(){
        int random = new Random().nextInt(difficultyCurrent + 1);
        if(difficultyW1 < random) summonWaveNormal11();
        else if (difficultyW2 < random) summonWaveNormal22();
        else if (difficultyW3 < random) summonWave3();
    }

    /**
     * For testing purposes only
     */
    public void summon() {
        programController.getArray().set(new EnemyFast(viewController, programController), 2, 2);
    }

    public void summonWaveNormal11() { //Change to private when done - only public for testing purposes
        for(int i = 0; i < 11; i++) {
            programController.getArray().set(new EnemyNormal(viewController, programController), i, 1);
        }
    }

    public void summonWaveMixed11() {
        for(int i = 0; i < 11; i += 2) {
            programController.getArray().set(new EnemyNormal(viewController, programController), i, 1);
        }
        for(int i = 1; i < 11; i += 2) {
            programController.getArray().set(new EnemyBurst(viewController, programController), i, 1);
        }
    }

    public void summonWaveNormal22() { //Change to private when done - only public for testing purposes
        for(int i = 0; i < 11; i++) {
            programController.getArray().set(new EnemyNormal(viewController, programController), i, 0);
        }
        for(int i = 0; i < 11; i++) {
            programController.getArray().set(new EnemyNormal(viewController, programController), i, 1);
        }
    }

    public void summonWave3() { //Change to private when done - only public for testing purposes

    }

}