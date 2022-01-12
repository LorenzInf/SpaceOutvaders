package my_project.model;

import KAGO_framework.control.ViewController;

import java.awt.image.BufferedImage;

public class Enemy2 extends Enemy{

    private BufferedImage enemy_2;

    public Enemy2(double x, double y, int hp, int damage, int speed, ViewController viewController) {
        super(x, y, 2, damage, speed, false, viewController);
    }
}
