package Lab3_Hero_Project;

class Robot extends Hero {
    public Robot(Job job) {
        this.job = job;
    }

    public int getINT() {
        return 25;
    }

    public String getRaceName() {
        return "ROBOT";
    }
}