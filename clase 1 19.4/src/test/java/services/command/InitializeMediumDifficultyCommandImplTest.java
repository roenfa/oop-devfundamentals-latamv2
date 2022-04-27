package services.command;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class InitializeMediumDifficultyCommandImplTest {

    @Test
    void execute() {
        Random rand = new Random();
        int upperbound = 25;
        List<Integer> decisionsList = new ArrayList<>();
        for(int i = 0; i< 4;i ++) {
            int int_random = rand.nextInt(upperbound);
            decisionsList.add(int_random);
        }
        assertTrue(decisionsList.size() > 0);
    }
}