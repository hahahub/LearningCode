package com.chapter14.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by yangyunming on 2018/8/1
 */
public abstract class PetCreator {
    private Random random = new Random(47);
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet(){
        int n = random.nextInt(types().size());
        try{
            return types().get(n).newInstance();
        }catch (InstantiationException e){
            throw new RuntimeException(e);
        }catch (IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }
    public Pet[] createArray(int size){
        Pet[] result = new Pet[size];
        for (int i = 0;i < size; i++)
            result[i] = randomPet();
        return  result;
    }
    public ArrayList<Pet> arrayList(int size){
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result,createArray(size));
        return result;
    }
}
