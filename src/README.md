
# Samuel Bhushan
# Lexi Implementation for OOP Design patterns

## Running Program

Note: This program has an automatic main function that demos Lexi as 
  direct text input is not possible yet

1. cd to src/ directory and run javac Main.java
2. run java Main with environment variables (see below)
   and a window should show up with some characters
3. Run a command (see commands below)


## Environment Variables

LEXI_LOOK_FEEL: 
- GREEN
- RED

LEXI_LOOK_FEEL:
- AWT
- SWING

## Commands

1. type an alphanumeric character after clicking glyph [2.] : insert text
2. click any glyph: move cursor
3. ctrl+i: increment text
4. ctrl+d: decrement text
5. ctrl+u: undo command
6. ctrl+r: redo command
7. ctrl+w: print word count to System.out
8. ctrl+q: quit program
9. click a button (areas with solid colored background): <function varies>

## Structure

src folder 
This folder contains the Main file and this README. 
  Its subfolders correspond to the different packages that Main uses.

src/command/ package
Contains the command history, and individual commands available to Lexi.

src/compositor package
Contains the overall compositor and concrete implementations (like SimpleCompositor)

src/glyph package
This contains the Glyph abstract class and many derived classes. 
  Factories for glyphs are also placed here.

src/window package
This contains the window/windowImp bridge pattern that handles windows
  and their different possible types.

src/iterator
This contains the iterator implementations primarily used for wordcount



