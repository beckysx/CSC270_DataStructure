package Lab9_TwentyQuestions;

public class QuestionNode extends Node {
    public QuestionNode(Node parent, String question, Node yes, Node no) {
        this.ele = question;
        this.parent = parent;
        this.yesChild = yes;
        this.noChild = no;
    }
}