package com.zarrouk.anis.mynews.Utils;

/**
 * Created by Anis Zarrouk on 26/06/2019
 */
public class Utils {
    public static Long executeTaskAfter7Seconds(){
        Long endTime = System.currentTimeMillis() + 7000;
        while (System.currentTimeMillis() < endTime){

        }
        return  endTime;
    }
}
