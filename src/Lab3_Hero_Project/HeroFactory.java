package Lab3_Hero_Project;

public class HeroFactory {

    public static HeroInterface createHero(String raceName, String jobName) {

        if (jobName == "WARRIOR") {
            Warrior Warrior = new Warrior();
            if (raceName == "ELF") {
                Elf ElfWarrior = new Elf(Warrior);
                return ElfWarrior;
            } else if (raceName == "DWARF") {
                Dwarf DwarfWarrior = new Dwarf(Warrior);
                return DwarfWarrior;
            } else if (raceName == "ROBOT") {
                Robot RobotWarrior = new Robot(Warrior);
                return RobotWarrior;
            } else {
                return null;
            }
        } else if (jobName == "ARCHER") {
            Archer Archer = new Archer();
            if (raceName == "ELF") {
                Elf ElfArcher = new Elf(Archer);
                return ElfArcher;
            } else if (raceName == "DWARF") {
                Dwarf DwarfArcher = new Dwarf(Archer);
                return DwarfArcher;
            } else if (raceName == "ROBOT") {
                Robot RobotArcher = new Robot(Archer);
                return RobotArcher;
            } else {
                return null;
            }
        } else if (jobName == "MAGE") {
            Mage Mage = new Mage();
            if (raceName == "ELF") {
                Elf ElfMage = new Elf(Mage);
                return ElfMage;
            } else if (raceName == "DWARF") {
                Dwarf DwarfMage = new Dwarf(Mage);
                return DwarfMage;
            } else if (raceName == "ROBOT") {
                Robot RobotMage = new Robot(Mage);
                return RobotMage;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }


}