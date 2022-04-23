package org.fundacionjala.devops.bootcamp;

import java.util.Random;

public class Board {

    int n=0;
    public int[][] matrix;

    public Board() {
    }

    public void createBoard(int size){
        this.n=size;
        matrix=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                matrix[i][j]=i*size+j+1;
            }
        }
        matrix[size-1][size-1]=0;
    }

    //printing the board:

    public void print(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //if the value stored at matrix[i][j] <=9, then print a space before it
                if(matrix[i][j]<=9){
                    System.out.print(matrix[i][j] + "  ");
                }else{
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //Method to shuffle the matrix, avoiding repeat values,allowing to store the shuffled matrix :
    public int[][] shuffle(){
        Random r=new Random();
        int aux=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int a=r.nextInt(n);
                int b=r.nextInt(n);
                aux=matrix[a][b];
                matrix[a][b]=matrix[i][j];
                matrix[i][j]=aux;
            }
        }

        return matrix;

    }
    //Method to return the shuffled matrix:
    public int[][] getShuffled(){
        return matrix;
    }

}

