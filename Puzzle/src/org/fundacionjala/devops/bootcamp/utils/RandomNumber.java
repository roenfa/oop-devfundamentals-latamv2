package org.fundacionjala.devops.bootcamp.utils;

import java.util.Map;
// I thinks this class should be abstract...
public class RandomNumber {

    public int pickRandomOption( Map<Integer, int[]> movesToPlay){
        int min = 1;
        int max = movesToPlay.size();
        int random = (int) (Math.random()*(max-min+1)+min);
        return random;
    }

}