package my_project.model;

import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;
import java.util.Random;

public class EnemyWave {

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
        if(difficultyW1 < random) summonWave1();
        else if (difficultyW2 < random) summonWave2();
        else if (difficultyW3 < random) summonWave3();
    }

    public void summonWave1(){
        EnemyNormal enemy = new EnemyNormal(viewController, programController);

    }

    private void summonWave2() {

    }

    private void summonWave3() {

    }
}
