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



