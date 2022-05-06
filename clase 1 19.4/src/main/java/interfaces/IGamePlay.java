package interfaces;

import java.util.List;
import java.util.Map;

public interface IGamePlay {

     Map<Integer, Map<Integer, Integer>> possiblePositionsList();
     void gameMovement(int decision, List<Integer> decisionsList );
     void gameMovementRandomVersion(int decision);
     List<Integer> callsNextMovement( List<Integer> decisionsList );
     int callsNextMovementRandom();
}
