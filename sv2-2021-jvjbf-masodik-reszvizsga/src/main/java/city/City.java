package city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();
    private long checkIsThereAnySpaceForNowBuilding;

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building){
        if(checkIsThereAnySpaceForNowBuilding + building.getArea() <= fullArea){
            buildings.add(building);
            checkIsThereAnySpaceForNowBuilding += building.getArea();
        }
        else {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }

    public Building findHighestBuilding(){
        Building highestBuilding = buildings.get(0);
        for(Building building: buildings){
            if(building.getLevels() > highestBuilding.getLevels()){
                highestBuilding = building;
            }
        }
        return highestBuilding;
    }

    public List<Building> findBuildingsByStreet(String street){
        List<Building> filteredBuildings = new ArrayList<>();
        for(Building building: buildings){
            if(building.getAddress().getStreet().equals(street)){
                filteredBuildings.add(building);
            }
        }
        return filteredBuildings;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople){
        boolean isThereAnyBuilding = false;
        for(Building building: buildings){
            if(building.calculateNumberOfPeopleCanFit() > numberOfPeople && !isThereAnyBuilding){
                isThereAnyBuilding = true;
            }
        }
        return isThereAnyBuilding;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
