import java.util.Random;
import java.util.Scanner;

public class NinjaCharacter {
    private int chakraPoints = 20;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            System.out.println("Choose an action: 'roll', 'skill', 'save', 'fireball', 'phoenix', 'dragon', 'fireball shower', 'phoenix fire', 'fire whip', 'ember bomb', 'end'");
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

        System.out.println("Long resting... Run again to start");
    }

    private void performSkillCheck() {
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

    private void performSavingThrow() {
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

    private void rollD20AndDisplayResult() {
        int rollResult = rollD20();
        System.out.println("You rolled a d20. Result: " + rollResult);
    }

    private void castFireballJutsu() {
        if (chakraPoints >= 5) {
            decrementChakra(5);
            int damage = rollDamage(3, 6);
            System.out.println("(saving throw DC: 13) You cast Fireball Jutsu! Damage: " + damage);
        } else {
            System.out.println("Not enough chakra to cast Fireball Jutsu.");
        }
    }

    private void castPhoenixSageFireTechnique() {
        if (chakraPoints >= 3) {
            decrementChakra(3);
            for (int i=0;i<3;i++) {
                int attackRoll = attackRoll(rollD20(), 5);
                int damage = rollDamage(3, 6);
                System.out.println("You cast Phoenix Fire Technique! 3 ranged attacks! Roll to hit: " + attackRoll + " Damage: " + damage);
            }
        } else {
            System.out.println("Not enough chakra to cast Phoenix Fire Technique.");
        }
    }

    private int attackRoll(int d20Result, int modifier) {
        int attackRoll = d20Result + modifier;
        return attackRoll;
    }

    private void castDragonFireTechnique() {
        if (chakraPoints >= 5) {
            decrementChakra(5);
            int attackRoll = attackRoll(rollD20(), 5);
            int damage = rollDamage(2, 8);
            System.out.println("You cast Dragon Fire Technique! Damage: " + damage);
        } else {
            System.out.println("Not enough chakra to cast Dragon Fire Technique.");
        }
    }

    private void castGreatFireballShower() {
        if (chakraPoints >= 5) {
            decrementChakra(5);
            int attackRoll = attackRoll(rollD20(), 5);
            int damage = rollDamage(2, 6);
            System.out.println("You cast Great Fireball Shower! Damage: " + damage + " to all targets in a 10-foot radius");
        } else {
            System.out.println("Not enough chakra to cast Great Fireball Shower.");
        }
    }

    private void castPhoenixFireTechnique() {
        if (chakraPoints >= 5) {
            decrementChakra(5);
            int attackRoll = attackRoll(rollD20(), 5);
            int damage = rollDamage(2, 6);
            System.out.println("You cast Phoenix Fire Technique! Damage: " + damage);
        } else {
            System.out.println("Not enough chakra to cast Phoenix Fire Technique.");
        }
    }

    private void castFireWhip() {
        if (chakraPoints >= 5) {
            decrementChakra(5);
            int damage = rollDamage(1, 8);
            System.out.println("You cast Fire Whip! Damage: " + damage);
        } else {
            System.out.println("Not enough chakra to cast Fire Whip.");
        }
    }

    private void castEmberBomb() {
        if (chakraPoints >= 5) {
            decrementChakra(5);
            int attackRoll = attackRoll(rollD20(), 5);
            int damage = rollDamage(1, 6);
            System.out.println("You cast Ember Bomb! Damage: " + damage + " in a 5-foot radius");
        } else {
            System.out.println("Not enough chakra to cast Ember Bomb.");
        }
    }

    private int rollDamage(int numDice, int sides) {
        int totalDamage = 0;
        for (int i = 0; i < numDice; i++) {
            totalDamage += random.nextInt(sides) + 1;
//            System.out.println(totalDamage);
        }
        return totalDamage;
    }

    private int rollD20() {
        return random.nextInt(20) + 1;
    }

    private void decrementChakra(int cost) {
        chakraPoints -= cost;
    }
}