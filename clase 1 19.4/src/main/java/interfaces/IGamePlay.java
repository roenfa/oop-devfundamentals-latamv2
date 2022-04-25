package interfaces;

import java.util.Map;

public interface IGamePlay {
     Map<Integer, Integer> findZeroPosition();
     Map<Integer, Integer> findNorthPosition();
     Map<Integer, Integer> findSouthPosition();
     Map<Integer, Integer> findEastPosition();
     Map<Integer, Integer> findWestPosition();
     Map<Integer, Map<Integer, Integer>> possiblePositionsList();
     void gameMovement();
}
