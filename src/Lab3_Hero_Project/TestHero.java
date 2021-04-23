package Lab3_Hero_Project;

public class TestHero {


    public static void main(String[] args) {
        int val = 10;

        HeroInterface ElfWarrior = HeroFactory.createHero("ELF", "WARRIOR");
        assert ElfWarrior.getDEX() == 25;
        assert ElfWarrior.getRaceName() == "ELF" : "not" + ElfWarrior.getRaceName();
        assert ElfWarrior.getJobName() == "WARRIOR" : "not" + ElfWarrior.getJobName();
        assert ElfWarrior.attack(val) == 225 : "not" + ElfWarrior.attack(val);

        HeroInterface ElfArcher = HeroFactory.createHero("ELF", "ARCHER");
        assert ElfArcher.getJobName() == "ARCHER";
        assert ElfArcher.attack(val) == 375;

        HeroInterface ElfMage = HeroFactory.createHero("ELF", "MAGE");
        assert ElfMage.getJobName() == "MAGE";
        assert ElfMage.attack(val) == 225;

        HeroInterface DwarfWarrior = HeroFactory.createHero("DWARF", "WARRIOR");
        assert DwarfWarrior.getSTR() == 25;
        assert DwarfWarrior.getRaceName() == "DWARF";
        assert DwarfWarrior.getJobName() == "WARRIOR";
        assert DwarfWarrior.attack(val) == 270;

        HeroInterface DwarfArcher = HeroFactory.createHero("DWARF", "ARCHER");
        assert DwarfArcher.attack(val) == 300;
        assert DwarfArcher.getJobName() == "ARCHER";


        HeroInterface DwarfMage = HeroFactory.createHero("DWARF", "MAGE");
        assert DwarfMage.attack(val) == 220;
        assert DwarfMage.getJobName() == "MAGE";


        HeroInterface RobotWarrior = HeroFactory.createHero("ROBOT", "WARRIOR");
        assert RobotWarrior.getINT() == 25;
        assert RobotWarrior.getRaceName() == "ROBOT";
        assert RobotWarrior.getJobName() == "WARRIOR";
        assert RobotWarrior.attack(val) == 220;

        HeroInterface RobotArcher = HeroFactory.createHero("ROBOT", "ARCHER");
        assert RobotArcher.attack(val) == 300;
        assert RobotArcher.getJobName() == "ARCHER";


        HeroInterface RobotMage = HeroFactory.createHero("ROBOT", "MAGE");
        assert RobotMage.getJobName() == "MAGE";
        assert RobotMage.attack(val) == 270;


        HeroInterface RobotNull = HeroFactory.createHero("ROBOT", "DOG");
        assert RobotNull == null;
        HeroInterface NullMage = HeroFactory.createHero("CAT", "MAGE");
        assert NullMage == null;
        HeroInterface NullNull = HeroFactory.createHero("DOG", "CAT");
        assert NullNull == null;


    }


}