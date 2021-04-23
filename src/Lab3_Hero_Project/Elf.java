package Lab3_Hero_Project;

class Elf extends Hero {
    public Elf(Job job) {
        this.job = job;
    }

    public int getDEX() {
        return 25;
    }

    public String getRaceName() {
        return "ELF";
    }
}