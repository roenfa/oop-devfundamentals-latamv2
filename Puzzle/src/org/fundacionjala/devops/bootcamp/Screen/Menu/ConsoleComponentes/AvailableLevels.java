// ConsoleComponents right?? no Componentes...
package org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes;

import java.util.Map;

abstract class AvailableLevels implements Indicators {

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");

        for(Integer in : printLevels().keySet()){
            for(Map.Entry<Integer, Integer> on: printLevels().get(in).entrySet()){
                builder.append("Level "+in+" = "+on.getKey()+" minutes and "+on.getValue()+"X"+on.getValue()+" table."+"\n");
            }
        }
;
        builder.append("\n");
        return builder.toString();
    }

    protected abstract Map<Integer, Map<Integer, Integer>> printLevels();
}
