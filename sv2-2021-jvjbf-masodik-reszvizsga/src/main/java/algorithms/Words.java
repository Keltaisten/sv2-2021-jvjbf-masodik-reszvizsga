package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public void addWord(String word){
        if(checkIfItIsWord(word)){
            words.add(word);
        }
    }

    private boolean checkIfItIsWord(String word) {
        if(word.contains(" ")){
            throw new IllegalArgumentException("It should be one word!");
        }else if(!word.toLowerCase().equals(word)){
            throw new IllegalArgumentException("Word should be lower case!");
        }
        return true;
    }

    public boolean isThereAWordTwice(){
        List<String> secondWords = new ArrayList<>();
        boolean isThereAnyTwice = false;
        for(String word: words){
            if(!secondWords.contains(word)){
                secondWords.add(word);
            }
            else{
                isThereAnyTwice = true;
            }
        }
        return isThereAnyTwice;
    }

    public List<String> getWords() {
        return words;
    }
}
