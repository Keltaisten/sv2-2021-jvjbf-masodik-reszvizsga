package filemanipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path){
        List<String> humansString = new ArrayList<>();
        try {
            humansString = Files.readAllLines(path);
        }catch (IOException ioe){
            throw new IllegalStateException("Can't read file!", ioe);
        }
        fillTheHumans(humansString);
    }

    private void fillTheHumans(List<String> humansString) {
        for(String humanData: humansString){
            String[] splittedHumanData = humanData.split(";");
            humans.add(new Human(splittedHumanData[0],splittedHumanData[1]));
        }
    }

    public void writeMaleHumansToFile(Path path){
        List<String> modifiedMales = filterTheMales();
        try {
            Files.write(path,modifiedMales);
        }catch (IOException ioe){
            throw new IllegalStateException("Cannot write file!");
        }



    }

    private List<String> filterTheMales() {
        List<String> males = new ArrayList<>();
        for(Human human: humans){
            if(human.getIdentityNumber().startsWith("1") || human.getIdentityNumber().startsWith("3")){
                males.add(human.getName() + ";" + human.getIdentityNumber());
            }
        }
        return males;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
