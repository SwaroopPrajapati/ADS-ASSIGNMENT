# ADS-ASSIGNMENT

*Problem Definition*:

A matrix of size[nxn] is to populated with random characters.A "word" is to be searched in the matrix. The search process starts from any location in the matrix and generate a path consisting of "word" spelling. This path should be continuous and three possible directions
allowed are:Up-Side-Down.
Input : Word from keyboard.

*Technology Stack* :   
    
1) Java JDK+ JRE Environment Version 1.8 for backend development.
2) Java swing and awt for setting crossword.

*Code Description* :
 
 1) findElement(int rowEle, int colEle, int inputLength) :-
    
    This method takes number of column and row as an input and the last index of input "word" (which is given by user). Then it tries to 
    find the last character of input word with characters stored in the matrix. Once it find out the character then it traverse to left and     upward in matrix to match the remaining characters by calling functions findUp() and findSide().
    
 2) findUp(int p, int q, int inputLength) :-
    
    This method uses parameter p and q to get next character, as the character matches with input word it decrement the value of               inputLength. Using recursion it traverse in upward direction till inputLength becomes 0.
 
 3) findSide(int p, int q, int inputLength) :-
    
    works same as findUp() method but only difference is it traverses in left direction to match the word.
    
 4) CrosswordPanel class is used to setup crossword, the setCrossword() method take matrix as input and show this matrix in crossword form
    using JTextField and highlighting the word using setForeground() method.
    
 *NOTE* :- Assignment.java is the main file which is supposed to run.   
    
*Contributor* :-
 Swaroop Prajapati
