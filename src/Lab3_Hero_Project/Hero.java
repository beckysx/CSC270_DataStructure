package Lab3_Hero_Project;

class Hero implements HeroInterface {
    protected Job job;
    public String race;

    public int attack(int val) {
        return job.attack(val, this);
    }

    public int getSTR() {
        return 20;
    }

    public int getDEX() {
        return 20;
    }

    public int getINT() {
        return 20;
    }

    public String getRaceName() {
        return race;
    }

    public String getJobName() {
        return job.toString();
    }
}