package Lab9_TwentyQuestions;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Node {
    String ele;
    Node parent;
    Node yesChild = null;
    Node noChild = null;
    String flag;


    public void playGame(Scanner in, PrintStream out) {
        Node parent = this.parent;
        if (yesChild == null && noChild == null) {
            out.println(Strings.IS_IT_A + ele + "?");
            String line = in.nextLine();
            if (line.equals("Y") || line.equals("y")) {
                out.println(Strings.I_WIN);
            } else {
                //get answer, create a new answerNode
                out.println(Strings.WHAT_IS_THE_ANSWER);
                String answer = in.nextLine();
                Node answerNode = new AnswerNode(null, answer);
                //get question, create a new questionNode
                out.println(Strings.NEW_QUESTION + ele + " and a " + answer);
                String question = in.nextLine();
                Node questionNode = new QuestionNode(null, question, null, null);
                //link new question node with old question
                if (this.flag == "y") {
                    parent.yesChild = questionNode;
                } else {
                    parent.noChild = questionNode;
                }
                questionNode.parent = parent;
                //get attr, link answer nodes to new question node
                out.println("Answering yes to " + question + " means " + answer + "?");
                line = in.nextLine();
                if (line.equals("Y") || line.equals("y")) {
                    //change flag
                    answerNode.flag = "y";
                    this.flag = "n";
                    //link new answer node to new question node
                    questionNode.yesChild = answerNode;
                    answerNode.parent = questionNode;
                    //link old answer node to new question node
                    questionNode.noChild = this;
                    this.parent = questionNode;
                } else {
                    //change flag
                    answerNode.flag = "n";
                    this.flag = "y";
                    //link new answer node to new question node
                    questionNode.noChild = answerNode;
                    answerNode.parent = questionNode;
                    //link old answer node to new question node
                    questionNode.yesChild = this;
                    this.parent = questionNode;
                }
                out.println(Strings.THANKS);


            }

        } else {
            //ask the question
            out.println(ele);
            String line = in.nextLine();
            //move to yesChild
            if (line.equals("Y") || line.equals("y")) {
                this.yesChild.playGame(in, out);
            }
            //move to noChild
            else {
                this.noChild.playGame(in, out);
            }

        }
    }
}