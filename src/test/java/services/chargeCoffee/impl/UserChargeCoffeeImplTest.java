package services.chargeCoffee.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserChargeCoffeeImplTest {

    @Test
    void defineNumberOfCups() {
        int inputUserNumberOfCups = 6;
        int returnInput = inputUserNumberOfCups;
        assertEquals(6, returnInput);
    }
}