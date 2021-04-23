package Lab3_Hero_Project;

class Dwarf extends Hero {
    public Dwarf(Job job) {
        this.job = job;
    }

    public int getSTR() {
        return 25;
    }

    public String getRaceName() {
        return "DWARF";
    }
}