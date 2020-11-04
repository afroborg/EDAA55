# Lab 2 - Using prebuilt classes (square)

## Tasks
- [x] Check out [documentation](http://fileadmin.cs.lth.se/cs/Education/EDAA55/doc/) for class `Square`
- [x] Duplicate `DrawSquare.java`, call the new file `DrawThreeSquares.java`
- [x] Make DrawThreeSquares.java draw three Squares.
  - **Note!** Only one instance of Square shall be created.
- [x] Comment out the initialization of the Square object.
- [x] Run `PrintClicks.java` and `PrintClicksDists.java`
- [x] Draw a program that:
  - [x] Draws a square on startup
  - [x] When a mousepress is registered, removes the square and draws a new one at the pointer position.
- [x] Modify previous point so that the squares stagger towards mouseclick
- [x] Copy the code from the previous point to a new file: `AnimatedSquare.java` and add delays using: 
```java
    SimpleWindow.delay(10);
```