package Lab3_Hero_Project;

class Archer extends Job {
    Archer() {
    }

    public int attack(int val, Hero hero) {
        return (int) (hero.getDEX() * 1.5 * val);
    }

    public String toString() {
        return "ARCHER";
    }
}