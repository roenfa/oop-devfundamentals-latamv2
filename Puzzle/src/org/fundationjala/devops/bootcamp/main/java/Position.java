import java.util.Scanner;

public class Position {

    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position() {

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Position enterPosition (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row position: ");
        int positionX = sc.nextInt();
        setRow(positionX - 1);
        System.out.print("Enter column position: ");
        int positionY = sc.nextInt();
        setColumn(positionY - 1);
        return this;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + (row+1) +
                ", column=" + (column+1) +
                '}';
    }
}
