# antlr_IDE_MatrixLang
This is the code of an ANTLR parser for a grammar of a languaje for matrix operations.
This is a very simple grammar. For this project it was requested for us to create am IDE
for creating and editing this grammar. For this it was necessary to translate our code to another programming languaje that can execute the program; on this case, the languaje to which the current project translates to, is CPP. The grammar allows some basic matrix operations like addition, substraction, product and tranponse. Thre have been added some error listeners for the grammar that will detect if the
error is syntatic, semantic or lexical. 

## Requierement
In this case, we are running the project on windows machines. We are using Java 17 SDK and python 3.10 verssion; so we invite you to use this same configuration for making the porject run smoothly.



## ANTLR setup
For setting the antlr module on out system and Intellij IDE, we followed the next tutorial that applys an small example:
```
https://www.youtube.com/watch?v=tkDfxdoQw4I&ab_channel=JavaBeginnerTutorials
https://www.youtube.com/watch?v=itajbtWKPGQ&t=304s&ab_channel=JavaBeginnerTutorials
```

## Py4J python library
As we are running the IDE on python popular GUI creation Tinkr, we made use of some python module that let us connect or use some Java class or object from a running JMV, so you must install and setup the python library on your project our IDE. This technology is very similar to java RMI lib. For installing this lib, you may go to the officila Py4J documentation site, where all py4y topics are explained on a very clcear way. You should also setup the Py4J module on Intellij, so you can run the server. 

## Compile and Run
For doing this step you must firstly setup antlr and py4j in your modules environment. Please go to the "ServerHandler.py" file and change line 159, and set the direction to your directory where you are storing the repository.

This command is an example of the command that Intellij uses or runs for running the server. You should open the Intellij IDE and run the proyect.
```
"C:\Program Files\Java\jdk-17.0.3.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.1\lib\idea_rt.jar=49338:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Gar-m\Desktop\javaMLang\javaCode\MLangProyect\out\production\MLangProyect;C:\Users\Gar-m\Desktop\lecole\metcompu\MatrixLang\src\antlr-4.10.1-complete.jar;C:\Users\Gar-m\AppData\Local\Packages\PythonSoftwareFoundation.Python.3.10_qbz5n2kfra8p0\LocalCache\local-packages\share\py4j\py4j0.10.9.5.jar serverHandler
```
Your must start the server before running the python IDE, this is because the python client must stablish firstly a connection with the server. Your must run the python IDE from the terminal or command prompt, since if you execute it from the file manager, it will set as root directory system32 directory. 

## Running the proyect
The following is as example of how the proyect gets runned and how it should behave.


https://user-images.githubusercontent.com/43997408/172416448-325135c9-a64a-466a-a1ea-b0d3912733b4.mp4

## ANTLR Grammar
```
grammar MLang;

/*  ======================================
 *  Parser Rules
 *  ======================================
 */

/* program declararation = where we declare the whole/general
 *                         structure of the program. Similar to
 *                         C program structure
 */
programDeclaration
    :   tk_main tk_bracket_open instructions tk_bracket_close
    ;


instructions
    :   instruction
    |   instruction instructions
    ;

/*
 *  instructions can be declarations or operations over variables
 *  previously declared. 
 */
instruction
    :   declaration instruction_semicolon
    |   asignation instruction_semicolon
    |   write instruction_semicolon
    ;

/*  declarations have the following structure. 
 *  <type> id1, id2, ..., idN;
 *  types can be int or matrix.
 */
declaration
    :   dataType variable_list
    ;


/*
 *  Variable list can go from one var declaration to many.
 *  in case of a list, variables are separated by a comma.
 *  Composed of tk_var's
 */
variable_list
    :   tk_id
    |   tk_id tk_comma variable_list
    ;


/*
 *  can be integer or matrix
 */
dataType
    :   tk_type_int
    |   tk_type_matrix
    ;


/*
 *  asignation instruction
 *  id1 = expression;
 */
asignation
    :   tk_id tk_asign expression
    ;

expression
    :   matrix 
    |   integer
    |   tk_id
    |   '(' expression ')'
    |   expression tk_prod expression
    |   expression (tk_add | tk_sub) expression
    |   tk_tran expression
    ;


/*
 *  impression instruction
 *  write variable;
 */
write
    :   tk_write tk_id
    ;

/*
 *  sequence of int values enclosed between brackets
 *  values are separated by commas when belong to same
 *  column and separation between a ';'.
 *  [1, 3, 0, 4; 2, 1, 5, 0; 1, 3, 2, 5; 7, 6, 4, 8]
 *  
 */
matrix
    :      tk_bracket_o columns tk_bracket_c
    ;

columns
    :   column
    |   column matrix_semicolon columns   
    ;

column
    :   integer
    |   integer tk_comma column   
    ;

integer
    :   Integer
    ;

instruction_semicolon
    :   tk_semicolon
    ;

matrix_semicolon
    :   tk_semicolon
    ;


/*  ======================================
 *  Tokens
 *  ======================================
 */

tk_main
    :   'main'
    ;

tk_bracket_open
    :   '{'
    ;

tk_bracket_close
    :   '}'
    ;

tk_type_int
    :   'int'
    ;

tk_type_matrix
    :   'matrix'
    ;

tk_id
    :   Identifier
    ;

tk_semicolon
    :   ';'
    ;

tk_colon
    :   ':'
    ;

tk_comma
    :   ','
    ;

tk_bracket_o
    :   '['
    ;

tk_bracket_c
    :   ']'
    ;

tk_asign
    :   '='
    ;

tk_add
    :   '+'
    ;

tk_sub
    :   '-'
    ;

tk_prod
    :   '*'
    ;

tk_tran
    :   '^'
    ;

tk_write
    :   'write'
    ;

/*  ======================================
 *  Lexer Rules
 *  ======================================
 */
Identifier
    :   [a-zA-Z_] [a-zA-Z_0-9]*
    ;

Integer
    :   [0-9]+
    ;

WS
    :   [ \t]+ -> skip
    ;

Newline
    :   ('\r' '\n'? | '\n') -> skip
    ;

BlockComment
    :   '/*' .*? '*/' -> skip
    ;




```
