package my_project.control;

import my_project.model.EnemyBoss;
import my_project.model.Player;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.view.Options;

import java.awt.*;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Menu menu;
    private Player player;
    private EnemyBoss enemyBoss;
    private GraphicalWindow window;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        // Setzt den Hintergrund auf Schwarz
        window = new GraphicalWindow(viewController, this);
        new InputManagerMainMenu(this, viewController);
        new InputManagerOptions(this, viewController, window.getOptions());
    }
    public void createPlayer(){
        Player player = new Player(10, 3,false,0,viewController);
    }
    public void createEnemyWave(){


    }

    /**
     * Wenn ein Gegner getroffen wurde -> Enemy verliert ein Leben
     * Wenn Enemy kein Leben mehr hat soll der enemy verschwinden
     */
    /*public boolean enemyGotHit() {

    }*/


    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }

    public GraphicalWindow getWindow(){
        return window;
    }

}
