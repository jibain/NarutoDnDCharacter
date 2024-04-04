import java.util.*;

public class CharacterSheet {
    /**
     * NOTES
     * Name: Silvio Uchiha
     * Class: Hunter Nin
     Background: Hunter
     Clan/Village: Uchiha

     Bonuses:
     Proficiency: +3
     Save DC: 13
     Ninjutsu Attack: +5
     GENJUTSU
     Genjutsu save DC = 13
     Genjutsu attack modifier = +5
     TAIJUTSU
     Taijutsu save DC = 12
     Taijutsu attack modifier = +4

     Proficient Skills:
     Stealth
     Perception
     Survival
     Investigation

     Equipment:
     Kunai
     Shuriken
     Explosive Tags
     Smoke Bombs
     Ninja Wire
     Flak Jacket
     **/

    public class NinjaCharacter {
        private static int chakraPoints = 20;
        private static Random random = new Random();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            boolean continuePlaying = true;
            while (continuePlaying) {
                System.out.println("Choose an action: roll 'skill', 'save', 'fireball', 'phoenix', 'dragon', 'fireball shower', 'phoenix fire', 'fire whip', 'ember bomb', 'end'");
                String action = scanner.nextLine();

                switch (action.toLowerCase()) {
                    case "roll":
                        rollD20AndDisplayResult();
                        break;
                    case "skill":
                        performSkillCheck();
                        break;
                    case "save":
                        performSavingThrow();
                        break;
                    case "fireball":
                        castFireballJutsu();
                        break;
                    case "phoenix":
                        castPhoenixSageFireTechnique();
                        break;
                    case "dragon":
                        castDragonFireTechnique();
                        break;
                    case "fireball shower":
                        castGreatFireballShower();
                        break;
                    case "phoenix fire":
                        castPhoenixFireTechnique();
                        break;
                    case "fire whip":
                        castFireWhip();
                        break;
                    case "ember bomb":
                        castEmberBomb();
                        break;
                    case "end":
                        continuePlaying = false;
                        break;
                    default:
                        System.out.println("Invalid action.");
                }

                System.out.println("Remaining Chakra Points: " + chakraPoints);
            }

            System.out.println("Goodbye!");
        }

        private static void performSkillCheck() {
            System.out.println("Select a skill: 'acrobatics', 'animal handling', 'arcana', 'athletics', 'deception', 'history', 'insight', 'intimidation', 'investigation', 'medicine', 'nature', 'perception', 'performance', 'persuasion', 'religion', 'sleight of hand', 'stealth', 'survival'");
            String skill = scanner.nextLine();

            int modifier = 0;
            switch (skill.toLowerCase()) {
                case "acrobatics":
                    modifier = 1;
                    break;
                case "animal handling":
                    modifier = 2;
                    break;
                case "arcana":
                    modifier = 2;
                    break;
                case "athletics":
                    modifier = 3;
                    break;
                case "deception":
                    modifier = 0;
                    break;
                case "history":
                    modifier = 2;
                    break;
                case "insight":
                    modifier = 2;
                    break;
                case "intimidation":
                    modifier = 0;
                    break;
                case "investigation":
                    modifier = 4;
                    break;
                case "medicine":
                    modifier = 2;
                    break;
                case "nature":
                    modifier = 2;
                    break;
                case "perception":
                    modifier = 6;
                    break;
                case "performance":
                    modifier = 0;
                    break;
                case "persuasion":
                    modifier = 0;
                    break;
                case "religion":
                    modifier = 2;
                    break;
                case "sleight of hand":
                    modifier = 3;
                    break;
                case "stealth":
                    modifier = 7;
                    break;
                case "survival":
                    modifier = 2;
                    break;
                default:
                    System.out.println("Invalid skill.");
                    return;
            }

            int result = rollD20() + modifier;
            System.out.println("Skill check result for " + skill + ": " + result);
        }
        private static void rollD20AndDisplayResult() {
            int rollResult = rollD20();
            System.out.println("You rolled a d20. Result: " + rollResult);
        }


        private static void performSavingThrow() {
            System.out.println("Select a saving throw: 'strength', 'dexterity', 'constitution', 'intelligence', 'wisdom', 'charisma'");
            String save = scanner.nextLine();

            int modifier = 0;
            switch (save.toLowerCase()) {
                case "strength":
                    modifier = 4;
                    break;
                case "dexterity":
                    modifier = 3;
                    break;
                case "constitution":
                    modifier = 5;
                    break;
                case "intelligence":
                    modifier = 2;
                    break;
                case "wisdom":
                    modifier = 1;
                    break;
                case "charisma":
                    modifier = 3;
                    break;
                default:
                    System.out.println("Invalid saving throw.");
                    return;
            }

            int result = rollD20() + modifier;
            System.out.println("Saving throw result for " + save + ": " + result);
        }
        private static void castFireballJutsu() {
            if (chakraPoints >= 5) {
                decrementChakra(5);
                int damage = rollDamage(3, 6);
                System.out.println("(saving throw DC: 13) You cast Fireball Jutsu! Damage: " + damage);
            } else {
                System.out.println("Not enough chakra to cast Fireball Jutsu.");
            }
        }

        private static void castPhoenixSageFireTechnique() {
            if (chakraPoints >= 5) {
                decrementChakra(5);
                int damage = rollDamage(3, 6);
                System.out.println("You cast Phoenix Sage Fire Technique! 3 ranged attacks! Damage: " + damage);
            } else {
                System.out.println("Not enough chakra to cast Phoenix Sage Fire Technique.");
            }
        }

        private static void castDragonFireTechnique() {
            if (chakraPoints >= 5) {
                decrementChakra(5);
                int damage = rollDamage(2, 8);
                System.out.println("You cast Dragon Fire Technique! Damage: " + damage);
            } else {
                System.out.println("Not enough chakra to cast Dragon Fire Technique.");
            }
        }

        private static void castGreatFireballShower() {
            if (chakraPoints >= 5) {
                decrementChakra(5);
                int damage = rollDamage(2, 6);
                System.out.println("You cast Great Fireball Shower! Damage: " + damage + " to all targets in a 10-foot radius");
            } else {
                System.out.println("Not enough chakra to cast Great Fireball Shower.");
            }
        }

        private static void castPhoenixFireTechnique() {
            if (chakraPoints >= 5) {
                decrementChakra(5);
                int damage = rollDamage(2, 6);
                System.out.println("You cast Phoenix Fire Technique! Damage: " + damage);
            } else {
                System.out.println("Not enough chakra to cast Phoenix Fire Technique.");
            }
        }

        private static void castFireWhip() {
            if (chakraPoints >= 5) {
                decrementChakra(5);
                int damage = rollDamage(1, 8);
                System.out.println("You cast Fire Whip! Damage: " + damage);
            } else {
                System.out.println("Not enough chakra to cast Fire Whip.");
            }
        }

        private static void castEmberBomb() {
            if (chakraPoints >= 5) {
                decrementChakra(5);
                int damage = rollDamage(1, 6);
                System.out.println("You cast Ember Bomb! Damage: " + damage + " in a 5-foot radius");
            } else {
                System.out.println("Not enough chakra to cast Ember Bomb.");
            }
        }
        private static int rollDamage(int numDice, int sides) {
            int totalDamage = 0;
            for (int i = 0; i < numDice; i++) {
                totalDamage += random.nextInt(sides) + 1;
            }
            return totalDamage;
        }

        private static int rollD20() {
            return random.nextInt(20) + 1;
        }

        private static void decrementChakra(int cost) {
            chakraPoints -= cost;
        }
    }
}
