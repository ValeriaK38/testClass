package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NameGenerator {
    private List<String> nameList;
    public NameGenerator(List<String> nameList){
        this.nameList=nameList;
    };

    public List<String> getNameList() {
        return nameList;
    }

    public String getName(){
        Collections.shuffle(nameList);
        Random randomName = new Random();
        return this.nameList.get(randomName.nextInt(nameList.size()));

    }
}
