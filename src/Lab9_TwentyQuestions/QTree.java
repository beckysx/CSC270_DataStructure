package Lab9_TwentyQuestions;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class QTree {
    Node root;

    Scanner in;
    PrintStream out;

    //initializes the game
    public QTree(InputStream in, PrintStream out) {
        this.out = out;
        this.in = new Scanner(in);
        Node duck = new AnswerNode(null, Strings.DUCK);
        Node rock = new AnswerNode(null, Strings.ROCK);
        root = new QuestionNode(null, Strings.IS_IT_ALIVE, duck, rock);
        duck.parent = root;
        duck.flag = "y";
        rock.parent = root;
        rock.flag = "n";
    }


    //plays the game, be sure to grab input from the Scanner "in", and send your output to "out".
    public void playGame() {
        root.playGame(in, out);
        out.println(Strings.PLAY_AGAIN);
        out.flush(); //speeds up the testing
        String line = in.nextLine();

        while (line.equals("Y") || line.equals("y")) {
            root.playGame(in, out);
            out.println(Strings.PLAY_AGAIN);
            out.flush();
            line = in.nextLine();
        }
    }


    public static void main(String[] args) {
        System.out.println("QTree");
        QTree t = new QTree(System.in, System.out);
        t.playGame();
    }


}
