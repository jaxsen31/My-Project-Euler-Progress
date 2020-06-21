package ProjectEuler;

import Toolbox.Timer;

/*
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
 */
public class qn15_LatticePaths {
    public static void main(String[] args){
        Timer timer = new Timer();

        int gridLength = 20;
        long[][] lattice = new long[gridLength+1][gridLength+1];

        //set side values to 1
        for (int i = 1; i <= gridLength; i++){
            lattice[0][i] = 1;
            lattice[i][0] = 1;
        }

        //set all other values
        for(int i = 1; i <= gridLength; i++){
            for (int j = 1; j <= gridLength; j++){
                lattice[i][j] = lattice[i][j-1] + lattice[i-1][j];
            }
        }

        for (int i = 0; i <= gridLength; i++){
            for (long j : lattice[i]){
                System.out.print(j + " ");
            }
            System.out.println("\b");
        }

        timer.end();
    }
}
