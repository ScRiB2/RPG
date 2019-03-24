package map;

import java.awt.geom.Point2D;
import java.util.*;
import character.Character;

public class Map {
    private int length = 30;
    private int width = 30;

    private HashMap<Double, Essences> essences = new HashMap<Double, Essences>();
    private HashMap<Double, Character> characters = new HashMap<Double, Character>();

    public Map(){
        addNewEssence(new Box(2,3));
        addNewEssence(new BigBox(3,2));
    }


    private Double getKey(Point2D coordinate){
        Double key;
        Double x = coordinate.getX();
        Double y = coordinate.getY();
        key = x > y ? x+y : -(x+y);
        return key;
    }

    private boolean checkFreeCell(Point2D coordinate){
        Double key = getKey(coordinate);
        if(!essences.containsKey(key) && !characters.containsKey(key)){
            return true;
        }
        else
            return false;
    }

    public void addNewEssence(Essences essence){
        if(checkFreeCell(essence.getCoordinate())){
            essences.put(getKey(essence.getCoordinate()),essence);
        }
        else
            System.out.println("В этих координатах уже есть объект");
    }

    public void addNewCharacter(Character character){
        if(checkFreeCell(character.getCoordinate())){
            characters.put(getKey(character.getCoordinate()),character);
        }
        else
            System.out.println("В этих координатах уже есть объект");
    }

    public void viewMap(){
        System.out.println("На карте расположены такие объекты:");
        for (HashMap.Entry<Double, Essences> entry: essences.entrySet()) {
            System.out.println(entry.getValue().getName());
        }
        System.out.println("И есть такие персонажи:");
        for (HashMap.Entry<Double, Character> entry: characters.entrySet()) {
            System.out.println(entry.getValue().getName());
        }
    }
}