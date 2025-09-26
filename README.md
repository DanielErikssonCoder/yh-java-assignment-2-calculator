# Calculator - Assignment 2 (Git)

A calculator system built in Java demonstrating understanding of Java and Git workflow.

## About the project

Built as part of YH education in Java System Development. 

The goal was to demonstrate understanding of both Java programming and Git with at least 4 feature branches.

I chose to build for VG requirements directly instead of starting simple and refactoring later. 

That's why the calculator has support for unlimited numbers from the beginning.

## Functionality

**Basic operations:**
- Addition
- Subtraction  
- Multiplication
- Division (with zero check)
- Modulus/Remainder (with zero check)

**Extra features:**
- Multi-number support (works for 2 or 100 numbers)
- Use previous result (reuse last answer)
- Color-coded menu with ANSI codes
- Clear screen between calculations
- Press Enter to continue
- Robust error handling that prevents crashes

## Project structure
```
src/
├── Main.java           # Starts the program
├── Calculator.java     # Coordinates between Menu and Operations
├── Menu.java           # All UI and user interaction
└── Operations.java     # Mathematical logic
```
Chose 4 classes for separation of concerns where each class has a clear responsibility. 

Could have thrown everything in Main but that shows no understanding of OOP.

## Git strategy

I interpreted the assignment as logical feature blocks instead of one branch per operation:

- `feature/menu` - Basic menu system
- `feature/addition-subtraction` - Two simple operations
- `feature/multiplication-division` - Two more complex ones
- `feature/modulus` - Remainder separate
- `feature/multi-numbers` - UI improvements and functionality

All branches are merged to master. Exceeds the requirement of at least 4 branches.

## How to run the program

### Compile and run

From project root:
```bash
# Compile
javac -d out src/*.java

# Run
java -cp out Main

Or simpler from src folder:

cd src
javac *.java  
java Main
```

## Usage

1. Choose operation (1-5)
2. Enter number count
3. Input each number
4. See the result
5. Option to reuse result in next calculation

The program handles all invalid input without crashing. Try typing letters instead of numbers to test the error handling.


## Technical choices
#### Arrays from the start: 
Built for multi-number directly. The method add(double[] numbers) is more flexible than add(double a, double b).

#### Error handling: 
Try-catch on all input with while-loops that force valid input. Scanner.nextLine() to clear the buffer.

#### Division/Modulus by zero: 
Returns original number instead of 0 to preserve the user's value.

#### Clear screen: 
Checks OS and uses correct command (cls for Windows, ANSI codes for Unix/Mac).

## Try these

- Division by 0
- Type letters when numbers expected
- Negative numbers (work in all operations)
- Use previous result feature

Everything should work without the program crashing!

