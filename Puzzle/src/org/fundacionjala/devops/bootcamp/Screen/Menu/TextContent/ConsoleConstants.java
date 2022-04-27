package org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent;

import java.util.List;
import java.util.Map;

public interface ConsoleConstants {
    void initializeOptions();
    void addSubmenu(int layer);
    void addOption(int layer, String option);
    void deleteOption (int layer, int option);
    Map<Integer, List<String>> getIt();
}
