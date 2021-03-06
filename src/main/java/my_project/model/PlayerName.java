package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.view.EnterName;
import my_project.view.Visual2DArray;

import java.awt.*;
import java.io.*;


public class PlayerName extends Entity {

    private Visual2DArray<ArrayKeyboard> array2DKeyboard;
    private List<EnterName> list;
    private final ArrayKeyboard keyA,keyB,keyC,keyD,keyE,keyF,keyG,keyH,keyI,keyJ,keyK,keyL,keyM,keyN,keyO,keyP,keyQ,keyR,keyS,keyT,keyU,keyV,keyW,keyX,keyY,keyZ,keyEnter;

    public PlayerName(ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        keyA = new ArrayKeyboard("A",viewController,programController);
        keyB = new ArrayKeyboard("B",viewController,programController);
        keyC = new ArrayKeyboard("C",viewController,programController);
        keyD = new ArrayKeyboard("D",viewController,programController);
        keyE = new ArrayKeyboard("E",viewController,programController);
        keyF = new ArrayKeyboard("F",viewController,programController);
        keyG = new ArrayKeyboard("G",viewController,programController);
        keyH = new ArrayKeyboard("H",viewController,programController);
        keyI = new ArrayKeyboard("I",viewController,programController);
        keyJ = new ArrayKeyboard("J",viewController,programController);
        keyK = new ArrayKeyboard("K",viewController,programController);
        keyL = new ArrayKeyboard("L",viewController,programController);
        keyM = new ArrayKeyboard("M",viewController,programController);
        keyN = new ArrayKeyboard("N",viewController,programController);
        keyO = new ArrayKeyboard("O",viewController,programController);
        keyP = new ArrayKeyboard("P",viewController,programController);
        keyQ = new ArrayKeyboard("Q",viewController,programController);
        keyR = new ArrayKeyboard("R",viewController,programController);
        keyS = new ArrayKeyboard("S",viewController,programController);
        keyT = new ArrayKeyboard("T",viewController,programController);
        keyU = new ArrayKeyboard("U",viewController,programController);
        keyV = new ArrayKeyboard("V",viewController,programController);
        keyW = new ArrayKeyboard("W",viewController,programController);
        keyX = new ArrayKeyboard("X",viewController,programController);
        keyY = new ArrayKeyboard("Y",viewController,programController);
        keyZ = new ArrayKeyboard("Z",viewController,programController);
        keyEnter = new ArrayKeyboard("ENTER",viewController, programController, 45);

        array2DKeyboard  = new Visual2DArray<ArrayKeyboard>(8,4,0,0, new Visual2DArray.VisualizationConfig(0,700,237,85,0,true,false,true,new Color(255,0,0,100),Color.WHITE,Color.black));
        array2DKeyboard.set(keyA,0,0);
        array2DKeyboard.set(keyB,1,0);
        array2DKeyboard.set(keyC,2,0);
        array2DKeyboard.set(keyD,3,0);
        array2DKeyboard.set(keyE,4,0);
        array2DKeyboard.set(keyF,5,0);
        array2DKeyboard.set(keyG,6,0);
        array2DKeyboard.set(keyH,7,0);
        array2DKeyboard.set(keyI,0,1);
        array2DKeyboard.set(keyJ,1,1);
        array2DKeyboard.set(keyK,2,1);
        array2DKeyboard.set(keyL,3,1);
        array2DKeyboard.set(keyM,4,1);
        array2DKeyboard.set(keyN,5,1);
        array2DKeyboard.set(keyO,6,1);
        array2DKeyboard.set(keyP,7,1);
        array2DKeyboard.set(keyQ,0,2);
        array2DKeyboard.set(keyR,1,2);
        array2DKeyboard.set(keyS,2,2);
        array2DKeyboard.set(keyT,3,2);
        array2DKeyboard.set(keyU,4,2);
        array2DKeyboard.set(keyV,5,2);
        array2DKeyboard.set(keyW,6,2);
        array2DKeyboard.set(keyX,7,2);
        array2DKeyboard.set(keyY,0,3);
        array2DKeyboard.set(keyZ,1,3);
        array2DKeyboard.set(keyEnter, 2,3);

        viewController.draw(this, GraphicalWindow.LEADERBOARD_INDEX);

        list = new List<>();
        list.toFirst();
        programController.getWindow().getEnterName().setName("");
        programController.getWindow().getEnterName().setLetterNumber(0);


    }

    public void insert(EnterName enterName) {
        list.toFirst();
        while (list.hasAccess() && list.getContent().getScore() > enterName.getScore()) {
            list.next();
        }
        if (list.hasAccess()) {
            list.insert(new EnterName(enterName.getName(), enterName.getScore(), viewController, programController));
        } else {
            list.append(new EnterName(enterName.getName(), enterName.getScore(), viewController, programController));
        }
        write();
    }

    public void drawStuff() {
        viewController.draw(array2DKeyboard,GraphicalWindow.ENTER_NAME_INDEX);
    }

    public void reset() {
        programController.getWindow().getEnterName().setName("");
        array2DKeyboard.setPointer(0,0);
        viewController.removeDrawable(array2DKeyboard,GraphicalWindow.ENTER_NAME_INDEX);
    }

    /**
     * Writes the File for the Score
     */
    public void write(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/text/names.txt"))) {
            list.toFirst();
            while(list.hasAccess()){
                writer.write(list.getContent().getName() + "," + list.getContent().getScore() + "\n");
                list.next();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Reads the File for the Score
     */
    public void read(){
        try {
            FileInputStream inputStream = new FileInputStream("src/main/java/text/names.txt");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] lineSplit = line.split(",");
                    list.append(new EnterName(lineSplit[0], Integer.parseInt(lineSplit[1]), viewController, programController));
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void draw(DrawTool drawTool){

    }

    public Visual2DArray<ArrayKeyboard> getArray2DKeyboard() {
        return array2DKeyboard;
    }

    public List getList() {
        return list;
    }
}
