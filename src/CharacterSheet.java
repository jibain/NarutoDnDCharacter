import java.util.Scanner;

public class CharacterSheet {
    /**
     * NOTES
     * Name: Silvio Uchiha
     * Class: Hunter Nin
     Background: Hunter
     Clan/Village: Uchiha

     Strength: 12 +1
     Dexerity: 12 +5
     Constitution: 13 +1
     Intelligence: 16 + 3
     Wisdom: 14 + 2
     Charisma: 10 +0

     Bonuses:
     Proficiency: +4
     Save DC: 15
     Ninjutsu Attack: +7
     GENJUTSU
     Genjutsu save DC = 14
     Genjutsu attack modifier = +6
     TAIJUTSU
     Taijutsu save DC = 13
     Taijutsu attack modifier = +5

     Proficient Skills:
     Stealth
     Perception
     Survival
     Investigation

     Equipment:
     1 scroll of Amaterasu
     1 scroll of Susano'o
     1 scroll of Multi Shadow Clone Jutsu
     Kunai
     Shuriken
     Explosive Tags
     Smoke Bombs
     Ninja Wire
     Flak Jacket
     **/
    public static void main(String[] args) {
        NinjaCharacter ninjaCharacter = new NinjaCharacter();
        ninjaCharacter.startGame();
    }
}
