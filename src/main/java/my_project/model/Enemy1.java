package my_project.model;

import KAGO_framework.control.ViewController;

public class Enemy1 extends Enemy{
    public Enemy1(double x, double y, int hp, int damage, int speed, ViewController viewController) {
        super(x, y, 2, damage, speed, viewController);
    }
}
