package services.produceCoffee.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFullDecisionTest {

    @Test
    void defineIfPotIsFull() {

        int input = 1;
        boolean returnsBoolean;
        if(input == 1){
            returnsBoolean = true;
        }
        else{
            returnsBoolean = false;
        }
        assertTrue(returnsBoolean == true);
    }

    @Test
    void defineWarmerPlateIsFull() {
        int input = 1;
        boolean returnsBoolean;
        if(input == 1){
            returnsBoolean = true;
        }
        else{
            returnsBoolean = false;
        }
        assertTrue(returnsBoolean == true);
    }

    @Test
    void defineWaterIsPresent() {

        int inputUserCoffeeGrounds = 7;
        int inputUserWaterAmount = 6;
        boolean returnsBoolean;

        if(inputUserWaterAmount < inputUserCoffeeGrounds){
            returnsBoolean = false;
        }else{
            returnsBoolean = true;
        }
        assertTrue(returnsBoolean == false);
    }
}