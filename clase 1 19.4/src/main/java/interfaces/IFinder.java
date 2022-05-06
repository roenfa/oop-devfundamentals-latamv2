package interfaces;

import java.util.Map;

public interface IFinder {
    Map<Integer, Integer> findZeroPosition(IBoardBuilder boardBuilder);
    Map<Integer, Integer> findNorthPosition(IBoardBuilder boardBuilder);
    Map<Integer, Integer> findSouthPosition(IBoardBuilder boardBuilder);
    Map<Integer, Integer> findEastPosition(IBoardBuilder boardBuilder);
    Map<Integer, Integer> findWestPosition(IBoardBuilder boardBuilder);
}
