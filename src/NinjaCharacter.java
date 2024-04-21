import java.util.Random;
import java.util.Scanner;

public class NinjaCharacter {
    private int level = 4;
    private int armorClass = 17;
    private int profBonus = 4;
    private int health = 27;
    private int chakraPoints = 24;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            System.out.println("Choose an action: 'roll', 'init', 'skill', 'save', 'action', 'bonus action', 'end'");
            String action = scanner.nextLine().toLowerCase();
            switch (action) {
                case "roll":
                    rollD20AndDisplayResult();
                    break;
                case "init":
                    int initRoll = rollD20() + 5 + profBonus;
                    System.out.println("Initiative roll: " + initRoll);
                    break;
                case "skill":
                    performSkillCheck();
                    break;
                case "save":
                    performSavingThrow();
                    break;
                case "action":
                    handleAction();
                    break;
                case "bonus action":
                    handleBonusAction();
                    break;
                case "end":
                    continuePlaying = false;
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }

            System.out.println("Remaining Chakra Points: " + chakraPoints);
        }

        System.out.println("Long resting... Run again to start");
    }

    private void handleAction() {
        System.out.println("Choose an action: 'fireball', 'phoenix', 'erupting flame', 'blazing hands', 'flame bolt', 'fire whip', 'flame strike', 'seal'");
        String action = scanner.nextLine().toLowerCase();

        switch (action) {
            case "fireball":
                castFireballJutsu();
                break;
            case "phoenix":
                castPhoenixSageFireTechnique();
                break;
            case "erupting flame":
                castEruptingFlame();
                break;
            case "blazing hands":
                castBlazingHands();
                break;
            case "flame bolt":
                castFlameBolt();
                break;
            case "fire whip":
                castFireWhip();
                break;
            case "flame strike":
                castFlameStrike();
                break;
            case "seal":
                castSealingJutsu();
                break;
            default:
                System.out.println("Invalid action.");
                break;
        }
    }

    private void handleBonusAction() {
        System.out.println("Choose a bonus action: sneak attack");
        String baction = scanner.nextLine().toLowerCase();

        switch (baction) {
            case "sneak attack":
                rollSneakAttack();
                break;
            default:
                System.out.println("Invalid action.");
                break;
        }
    }

    private void rollSneakAttack() {
        int damage = rollDamage(1,6);
        System.out.println(damage);
    }

    private void performSkillCheck() {
        System.out.println("Select a skill: 'acrobatics', 'animal handling', 'arcana', 'athletics', 'deception', 'history', 'insight', 'intimidation', 'investigation', 'medicine', 'nature', 'perception', 'performance', 'persuasion', 'religion', 'sleight of hand', 'stealth', 'survival'");
        String skill = scanner.nextLine();
        int modifier = 0;
        switch (skill.toLowerCase()) { //should be modifier plus proficiency for some
            case "acrobatics":
                modifier = 5;
                break;
            case "animal handling":
                modifier = 2;
                break;
            case "arcana":
                modifier = 3;
                break;
            case "athletics":
                modifier = 3;
                break;
            case "deception":
                modifier = 0;
                break;
            case "history":
                modifier = 3;
                break;
            case "insight":
                modifier = 2;
                break;
            case "intimidation":
                modifier = 0;
                break;
            case "investigation":
                modifier = 5;
                break;
            case "medicine":
                modifier = 2;
                break;
            case "nature":
                modifier = 3;
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
                modifier = 3;
                break;
            case "sleight of hand":
                modifier = 5;
                break;
            case "stealth":
                modifier = 9;
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
                modifier = 1;
                break;
            case "dexterity":
                modifier = 5;
                break;
            case "constitution":
                modifier = 1;
                break;
            case "intelligence":
                modifier = 3;
                break;
            case "wisdom":
                modifier = 2;
                break;
            case "charisma":
                modifier = 0;
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
                int attackRoll = attackRoll(rollD20(), 7);
                int damage = rollDamage(3, 6);
                System.out.println("You cast Phoenix Fire Technique! 3 ranged attacks! Roll to hit: " + attackRoll + " Damage: " + damage);
            }
        } else {
            System.out.println("Not enough chakra to cast Phoenix Fire Technique.");
        }
    }

    private int attackRoll(int d20Result, int modifier) {
        int attackRoll = d20Result + modifier;
        System.out.println("Advantage? a/d/n");
        String ad = scanner.nextLine();
        if(ad.equals("a")){
            int attackRollAd = rollD20() + modifier;
            if(attackRollAd > attackRoll){
                return attackRollAd;
            }
        }else if(ad.equals("d")){
            int attackRollAd = rollD20() + modifier;
            if(attackRollAd < attackRoll){
                return attackRollAd;
            }
        }else{
            return attackRoll;
        }
        return attackRoll;
    }

    private void castEruptingFlame() {
        if (chakraPoints >= 3) {
            decrementChakra(3);
            System.out.println("Target must succeed a Dexerity saving throw:(check char sheet)");
            int damage = rollDamage(2, 8);
            System.out.println("You cast Erupting Flame Technique! Damage: " + damage);
        } else {
            System.out.println("Not enough chakra to cast Erupting Flame Technique.");
        }
    }

    private void castSealingJutsu() {
        if (chakraPoints >= 0) {
            decrementChakra(0);
            System.out.println("Target must succeed a Consitution saving throw:(check char sheet)");
            System.out.println("Target sealed.");
        } else {
            System.out.println("Not enough chakra to cast Sealing Jutsu");
        }
    }


    private void castBlazingHands() { //15 foot cone
        if (chakraPoints >= 5) {
            decrementChakra(5);
            System.out.println("Target must succeed a Dexerity saving throw:(check char sheet)");
            int damage = rollDamage(4, 4);
            System.out.println("You cast Blazing Hands! Damage: " + damage + " to all targets in a 15-foot cone");
        } else {
            System.out.println("Not enough chakra to cast Blazing Hands.");
        }
    }

    private void castFlameBolt() { //range 60 feet
        if (chakraPoints >= 4) {
            decrementChakra(4);
            int attackRoll = attackRoll(rollD20(), 7);
            int damage = rollDamage(2, 10);
            System.out.println("You roll a " + attackRoll + " to hit.");
            System.out.println("You cast Flame Bolt! Damage: " + damage);
        } else {
            System.out.println("Not enough chakra to cast Flame Bolt");
        }
    }

    private void castFireWhip() {
        if (chakraPoints >= 4) {
            decrementChakra(4);
            int attackRoll = attackRoll(rollD20(),7);
            int damage = rollDamage(1, 8);
            System.out.println("You roll a " + attackRoll + " to hit.");
            System.out.println("You cast Flame Whip! Damage: " + damage);
        } else {
            System.out.println("Not enough chakra to cast Flame Whip.");
        }
    }

    private void castFlameStrike() { // 10 foot radius, 20 foot vertical column, 60 feet
        if (chakraPoints >= 5) {
            decrementChakra(5);
            System.out.println("Target must succeed a Dexerity saving throw:(check char sheet)");
            int damage = rollDamage(2, 8);
            System.out.println("You cast Flame Strike! Damage: " + damage + " in a 10-foot radius");
        } else {
            System.out.println("Not enough chakra to cast Flame Strike.");
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