package my_project.model;

import KAGO_framework.control.ViewController;

import java.awt.image.BufferedImage;

public class EnemyBoss extends Enemy{

    private BufferedImage enemy_boss;

    public EnemyBoss(double x, double y, int hp, int damage, int speed, ViewController viewController) {
        super(x, y, hp, damage, speed, viewController);
    }
}
