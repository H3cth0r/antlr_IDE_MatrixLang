/*
TODO
*/

main
{
matrix A, B, R1, R2, R3;
int Z, number, number_two;

Z = 1;

number_two = 2;
number = number_two;

int number_1;

A = [2, 0, 1; 3, 0, 0; 5, 1, 1];
B = [1, 0, 1; 1, 2, 1; 1, 1, 0];

R1= A + B;
R2= A - B;
R3= ^R2 + R1;

write R3;
}


















