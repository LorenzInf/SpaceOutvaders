package my_project.model;

import KAGO_framework.control.ViewController;

public class EnemyBoss extends Enemy{
    public EnemyBoss(double x, double y, int hp, int damage, int speed, ViewController viewController) {
        super(x, y, hp, damage, speed, viewController);
    }
}
