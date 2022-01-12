package my_project.model;

import KAGO_framework.control.ViewController;

import java.awt.image.BufferedImage;

public class Enemy1 extends Enemy{

    private BufferedImage enemy_1;

    public Enemy1(double x, double y, int hp, int damage, int speed, ViewController viewController) {
        super(x, y, 2, damage, speed, false, viewController);
    }
}
