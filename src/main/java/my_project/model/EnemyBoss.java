package my_project.model;

import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;

public class EnemyBoss extends Enemy {

    public EnemyBoss(ViewController viewController, ProgramController programController, boolean movingRight, int posX, int posY){
        super(viewController, programController,movingRight,posX,posY);
        hp = 5;
    }

    //TODO yeah so like actually code a boss lmao L lol ok
    // mehr Leben
    // zufällige Attacke wird ausgewählt + timer

}
