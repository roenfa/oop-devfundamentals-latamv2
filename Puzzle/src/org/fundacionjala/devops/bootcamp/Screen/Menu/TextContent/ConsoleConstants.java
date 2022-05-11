package org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent;

import java.util.List;
import java.util.Map;

// ConsoleMenu... I think so...
public interface ConsoleConstants {
    void initializeOptions();
    // I think the 3 below functions are not needed, right?
    void addSubmenu(int layer);
    void addOption(int layer, String option);
    void deleteOption (int layer, int option);
    Map<Integer, List<String>> getIt();
}
