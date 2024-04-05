import java.util.Scanner;

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
    public static void main(String[] args) {
        NinjaCharacter ninjaCharacter = new NinjaCharacter();
        ninjaCharacter.startGame();
    }
}
