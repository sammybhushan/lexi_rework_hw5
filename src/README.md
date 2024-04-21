
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

i: increment text
d: decrement text
u: undo command
r: redo command

click a button (areas with solid colored background) 


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



