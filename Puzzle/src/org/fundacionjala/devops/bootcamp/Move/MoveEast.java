package org.fundacionjala.devops.bootcamp.Move;

public class MoveEast implements Command {

    @Override
    public int execute(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = matrix[i][j + 1];
                    matrix[i][j + 1] = 0;
                    return 1;
                }
            }
        }
        return 0;
    }
}


