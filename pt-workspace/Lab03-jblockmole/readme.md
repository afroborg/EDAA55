# Lab 3 - blockmole

## Tasks
1. 
   - [x] Create a new class called `Mole.java` in the *src* directory
   - [x] Add the following code to its main-method:
   ```java
   System.out.println("Keep on digging!");
   ```
   - [x] Import the class `SimpleWindow` from the cs_pt library in your workspace
   - [x] Add this code to your main-method:
   ```java
   SimpleWindow w = new SimpleWindow(300, 500, "Digging");
   w.moveTo(10, 10);
   w.lineTo(10, 20);
   w.lineTo(20, 20);
   w.lineTo(20, 10);
   w.lineTo(10, 10);
   ```

2. 
   - [x] Structure some of your code to a new class called `Graphics` in a separate file
     - [x] Make `SimpleWindow w` a private attribute of `Graphics`
     - [x] Create a method called `square`
     - [x] Move the logic for drawing the square to the `square` method
   - [x] Initialize a new variable, `g` of type `Square` in the main method of `Mole.java`
   - [x] Run the `square` method

3. 
   - [x] Add the following attributes to `Graphics`:
     - `private int width`
     - `private int blockSize`
     - `private int height`
   - [x] Create a constructor with the parameters `w`, `h` and `b`. Map these paramters to `width`, `height`and `blockSize`.
   - [x] Initialize the `SimpleValue w` attribute inside the constructor. Set the height and width to their respective values * `blockSize`.
   - [x] Create a new method inside `Graphics` called `block` that takes two integers `x` and `y` as parameters
   - [x] Paste the following code snippet into its body:
   ```java
   int left = x * blockSize;
   int right = left + blockSize - 1;
   int top = y * blockSize;
   int bottom = top + blockSize - 1;
   for(int row = top; row <= bottom; row ++){
       w.moveTo(left, row);
       w.lineTo(right, row);
   }
   ```

4. 
    - [x] Create a new class called `Colors`
    - [x] Add the following constants
    ```java
    public static final Color MOLE = new Color(51, 51, 0);
    public static final Color SOIL = new Color(153, 102, 51);
    public static final Color TUNNEL = new Color(204, 153, 102);
    ```
  - [x] Add a `color` paramter of type `Color` to the `blocks` method of `Graphics`
  - [x] Add logic to change the line color to `color` before drawing the block
  - [x] Edit your main method and add one of the three colors when calling `blocks`
  - [x] Implement get-handlers for `width` and `height` 
5. 
    - [x] Add a `rectangle` method to `Graphics`. It should take three parameters:
    - `int x`
    - `int y`
    - `int width`
    - `int height`
    - `Color c`
    - [x] Add the following snippet to draw the rectangle:
    ```java
    for (int yy = y; yy < y + height; yy++){
        for(int xx = x; xx < x + width; xx++){
            block(xx, yy, c);
        }
    }
    ```
    - [x] Add a `drawWorld` void method inside the `Mole` class that draws a rectangle with the color `Colors.SOIL`
6. 
  - [x] Add the following method in the `Graphics` class:
    ```java
    public char waitForKey() {
      return w.waitForKey();
    }
    ```
7. 
  - [x] Add a new void method to `Mole` called `dig`
  - [x] Add logic to listen to `w`, `a`, `s` and `d` keypresses and dig tunnels with your mole.


## Optional Tasks

8. 
   - [x] Add if-statements so that the mole can't dig itself outside of the screen
9. 
   - [x] Add sky and grass to the screen
10. 
    - [x] If the mole is above the soil, make it so it can run but won't draw any tunnels.