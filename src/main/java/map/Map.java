package map;

import java.util.ArrayList;
import character.Character;

public class Map {
    private int length = 100;
    private int width = 100;
    ArrayList<Essences> essences = new ArrayList();
    ArrayList<Character> characters = new ArrayList();
    public Map(){
        essences.add(new Box(2,3));
        essences.add(new BigBox(20,45));
    }
    public void addNewCharacter(Character character){
        characters.add(character);
    }

    public void viewMap(){
        System.out.println("На карте расположены такие объекты:");
        for (Essences essence: essences) {
            System.out.println(essence.getName());
        }
        System.out.println("И есть такие персонажи:");
        for (Character character: characters) {
            System.out.println(character.getName());
        }
    }
}