package Lab3_Hero_Project;

class Mage extends Job {
    Mage() {
    }

    public int attack(int val, Hero hero) {
        return hero.getINT() * val + hero.getDEX();
    }

    public String toString() {
        return "MAGE";
    }

}