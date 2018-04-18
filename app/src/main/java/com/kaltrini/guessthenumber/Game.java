package com.kaltrini.guessthenumber;

import java.util.Random;

/**
 * Created by KaltrinI on 18.04.2018.
 */

public class Game {

    static Random random=new Random();
    private int first;
    private int second;
    private int third;
    private String comb;
    public Game(){

     Generate();
    }

    public void Generate(){

        do {

            first=random.nextInt(10);
            second=random.nextInt(10);
            third=random.nextInt(10);

        }while (first==second||first==third||second==third);

        comb=String.format("%d%d%d",first,second,third);
    }


    public String getComb(){
        return comb;
    }

    public void NewGame(){
        Generate();
    }

}
