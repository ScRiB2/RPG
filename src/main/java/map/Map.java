package map;

import java.util.ArrayList;
import character.Character;

public class Map {
    private int length = 100;
    private int width = 100;

    private ArrayList<Essences> essences = new ArrayList<Essences>();
    private ArrayList<Character> characters = new ArrayList<Character>();

    public Map(){
        essences.add(new Box(2,3));
        essences.add(new BigBox(20,45));
    }
    public void addNewCharacter(Character character){

        characters.add(character);
    }

    private boolean checkFreeCells(Object object){
        if(object instanceof Essences){
            if (essences.isEmpty())
                return true;
            double x = ((Essences) object).getCoordinate().getX();
            double y = ((Essences) object).getCoordinate().getY();
            for (int i = 0; i < ((Essences) object).length; i++) {
                for (int j = 0; j < ((Essences) object).width; j++) {

                }
            }
        }
        return true;
    }

    public void addNewEssence(Essences essence){

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