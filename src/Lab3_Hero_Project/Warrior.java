package Lab3_Hero_Project;

class Warrior extends Job {
    Warrior() {
    }

    public int attack(int val, Hero hero) {
        return hero.getSTR() * val + hero.getDEX();
    }

    public String toString() {
        return "WARRIOR";
    }


}