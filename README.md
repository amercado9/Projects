Project: Image Scanner

Name: Alexa Mercado

Description: This program processes multiple images specified by the user, where each image is represented as a 2D character array. 
The program identifies and groups connected components of '*' characters, which represent colored pixels. It recursively searches for
connected components using depth-first search (DFS), where two '*' characters are considered connected if they share a north, south, east,
or west edge. Once the connected components are found, the program assigns each group a unique letter to color them distinctly. The final 
output displays the colored images along with the number of groups and their respective sizes.

Features:
-Reads multiple images from user input.
-Uses recursion to identify and color connected components.
-Assigns unique characters to different connected components.
-Displays the processed images with colored groups.
-Prints the number of groups and their sizes.

How It Works:

1.The user inputs the number of images to process.

2.For each image, the user inputs its dimensions (rows and columns) followed by the pixel data ('*' for colored pixels and other characters for empty spaces).

3.The program stores the images in an ArrayList. It iterates through each image to identify connected components using the SearchNeighbors method.

4.Each discovered connected component is assigned a new character.

5.The processed images are printed along with the number and sizes of the connected groups.


Implementation Details


main Method: 

-Reads image dimensions and stores images in an ArrayList.

-Iterates through each image and initializes a HashMap to track group sizes.

-Calls SearchNeighbors to identify and color connected components.

-Prints the modified image and component statistics.

SearchNeighbors Method:

-Recursively checks north, south, east, and west neighbors of a '*' character.

-Colors the connected component with a new character.

-Returns the size of the component.

printGrid Method:

-Prints the modified 2D array representing the image with colored groups.


Example Input:

 2
 
 3 3
 
 *..
 
 .**
 
 *..
 
 8 10
 
 .........*
 
 ...**....*
 
 ..........
 
 ....*..*..
 
 ...*...*..
 
 .......**.
 
 ....**....
 
 ..........


Example Output

 a..
 
 .bb
 
 c..
 
 1  2
 
 2  1
 
 .........a
 
 ...bb....a
 
 ..........
 
 ....c..d..
 
 ...e...d..
 
 .......dd.
 
 ....ff....
 
 ..........
 
 1 2
 
 2 3
 
 4 1

Requirements:

Java Development Kit (JDK) 20.0.2 or higher

A Java-compatible text editor or IDE


Compilation & Execution


Compile the program:
javac Project1.java

Run the program:
java Project1 < test1.txt


Error Handling:

The program includes exception handling to manage input errors. It ensures valid image dimensions and character constraints are met.


Future Improvements:

Implement diagonal connectivity for more complex grouping. Use a graphical interface to display images visually.
This project demonstrates recursion, depth-first search, and character manipulation in Java to solve a connected-component problem efficiently.


