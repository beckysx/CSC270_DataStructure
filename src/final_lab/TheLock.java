package final_lab;

// given by Dr.Allen

public class TheLock {
    private String solution;
    private String guess;
    int length;
    private static final int actions = 4;

    public TheLock(String name, int length) {
        this.length = length;
        this.guess = "";
        this.solution = "";
        String temp = name + length;
        int num = temp.hashCode();
        num = Math.abs(num);

        for (int i = 0; i < length; ++i) {
            this.solution = this.solution + num % 4;
            num /= 4;
        }

    }

    public TheLock(String name) {
        this(name, 16);
    }

    public void twistIt() {
        this.guess = this.guess + "0";
    }

    public void pokeIt() {
        this.guess = this.guess + "1";
    }

    public void pullIt() {
        this.guess = this.guess + "2";
    }

    public void shakeIt() {
        this.guess = this.guess + "3";
    }

    public boolean isUnlocked() {
        return this.solution.equals(this.guess);
    }

    public void resetLock() {
        this.guess = "";
    }
}
