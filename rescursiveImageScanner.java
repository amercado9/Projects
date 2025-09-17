/*Project: Image Scanner
*  Name: Alexa Mercado 
*    
 *  Description: This program reads in a number of images specified by the user that will be of 
 *  a numbr of rows and columns inputted by the user. The program will read in the images as 2d
 *  arrays and will search for '*' which are the colored pixels of the image. The program will 
 *  recursively search for connected components of '*' known as groups which are connected if one *
 *  shares a north, south, east, or west edge. The program will color the groups with a letter and
 *  print the images with the connected componennts colored. It will also print the size of the 
 *  groups and the number of groups in the image.
 * */

import java.util.*;
public class Project1 {
/*
 *  The main method reads in the number of images and creates an Arraylist, then reads in dimensions
 *  and the individual images and stores the dimensions and images in char[][] grid, to store them in
 *  the Arraylist. The program will then iterate through the images and create a hashmap to store the
 *  size of the connected components and the number of groups in the image. The program will then call
 *  the SearchNeighbors method to search for connected components and color them with a new color. The  
 *  program will then print the colored images with the connected components colored and print the size 
 *  of the groups and the number of groups in the image.
 *  @param String[] args
 *  
 */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char color = 'a';
    try {
      ArrayList<char[][]> images = new ArrayList<>();
      int numofImg = Integer.parseInt(scanner.nextLine().trim());

      for (int i = 0; i < numofImg; i++){
        String[] dimensions = scanner.nextLine().trim().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] grid = new char[rows][cols];

        for(int r = 0;r < rows; r++){
          String rowInput = scanner.nextLine().trim();
          for (int j = 0; j < cols; j++) {
          
              grid[r][j] = rowInput.charAt(j);
          }
          }
        
        images.add(grid);
        scanner.nextLine();
    }

   for (int imageIndex = 0; imageIndex < images.size(); imageIndex++) {
    HashMap<Integer, Integer> groupSize = new HashMap<>();
      
      char[][] grid = images.get(imageIndex);
  
      for (int r = 0; r < grid.length; r++) {
          for (int c = 0; c < grid[r].length; c++) {
            int componentSize = SearchNeighbors(grid, r, c, color);
            if(componentSize > 0){
              color++;
              groupSize.put(componentSize, groupSize.getOrDefault(componentSize, 0) + 1);
            }
          }
      }  printGrid(grid);
      for(Map.Entry<Integer, Integer> entry : groupSize.entrySet()){
        System.out.println(entry.getKey() + " " + entry.getValue());
      }
      System.out.println();
      scanner.close();
  }
    }catch (Exception e) {
      
    }
    
  }

 /* Searches for connected components of '*' in the 2d array grid. If it encounters a '*' it 
 *   will chech the north, south, east, and west neighbors of the '*' and color them with the
 *   new color if they are connected.
 *  @param char[][] grid- 2d array that represents the image
 *  @param int r- row index
 *  @param int c- column index
 *  @param char color- the new color character that will be used to color the connected components
  * @return int- the size of the connected component
  */
  public static int SearchNeighbors(char[][] grid, int r, int c, char color) {
    if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '*'){
      return 0;
    }
      grid[r][c] = color;
    return 1 + SearchNeighbors(grid, r-1, c, color) 
             + SearchNeighbors(grid, r+1, c, color) 
             + SearchNeighbors(grid, r, c-1, color) 
             + SearchNeighbors(grid, r, c+1, color);
   
  }

/*Prints the 2d array grid that represents the image
 * @param char[][] grid
 * 
 */
  public static void printGrid(char[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        System.out.print(grid[r][c]);
      }
      System.out.println();
    }
  }
  

}
  

