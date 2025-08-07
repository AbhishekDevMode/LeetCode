import java.io.*;
import java.util.*;

public class Spiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//int n=5;
        int n = 10;
            char[][] grid = new char[n][n];
            // Fill grid with spaces
            for (int i = 0; i < n; i++) Arrays.fill(grid[i], ' ');
            int layer = 0;
            int numLayers = (n + 1) / 2;
            int y=0;
            while (layer < numLayers) {
                int first = layer, last = n - layer - 1;
                // Top row
                for (int j = first; j <= last; j++) grid[first][j] = '*';
                // Right column
                for (int i = first + 1; i <= last; i++) grid[i][last] = '*';
                // Bottom row
                if (last != first)
                    for (int j = last - 1; j >= first; j--) grid[last][j] = '*';
                // Left column
                if (last != first)
                    for (int i = last - 1; i > first+1; i--) grid[i][first] = '*';
                layer += 2;
            }
            // Print
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bw.write(grid[i][j]);
                    if (j != n - 1) bw.write(" ");
                }
                bw.write("\n");
            }
        bw.flush();
        }
    }



