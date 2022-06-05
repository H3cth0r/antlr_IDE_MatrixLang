# ifndef MATRIX
# define MATRIX


#include <iostream>
#include <iterator>                         // For iterating lists
#include <list>                             // List of list for matrix
#include <vector>


class Matrix
{
    private:
    protected:
    public:
        std::vector<std::vector<double>> matrix_vals;                            // + ============
        int rows;
        int cols;

        // Constructors
        Matrix(int, int);                   // Setting size
        Matrix(std::vector<std::vector<double>>);                                 // + =======
        Matrix();                           // Empty
        Matrix(const Matrix&);              // Object
        void operator =(const Matrix&);   // Overloading "="
        void operator =(const std::vector<std::vector<double>>);                   // + =======
        

        // Overloading for printing
        friend std::ostream& operator <<(std::ostream&, const Matrix&);
        void print();

        // Operation methods


        // Operational variables
        void rows_n_cols(){
            this->cols = matrix_vals.size();
            this->rows = matrix_vals.front().size();
            for(auto const i : matrix_vals){
                if(i.size() != rows){
                    std::cout << "not consistent number of rows!\n";
                    return;
                }
            }
        }


        // Overloading arithmetic operators
        Matrix& operator +=(const Matrix&);
        Matrix& operator +=(const double&);

        Matrix& operator -=(const Matrix&);
        Matrix& operator -=(const double&);
        
        Matrix& operator *=(const Matrix&);
        Matrix& operator *=(const double&);
        
        Matrix& operator ++();
        
        friend Matrix operator+(const Matrix&, const Matrix&);
        friend Matrix operator+(double, const Matrix&);
        friend Matrix operator+(const Matrix&, double);

        friend Matrix operator-(const Matrix&, const Matrix&);
        friend Matrix operator-(double, const Matrix&);
        friend Matrix operator-(const Matrix&, double);
        
        friend Matrix operator*(const Matrix&, const Matrix&);
        friend Matrix operator*(double, const Matrix&);
        friend Matrix operator*(const Matrix&, double);

};



Matrix::Matrix(int t_rows, int t_cols)
{
    this->rows = t_rows;
    this->cols = t_cols;
}
Matrix::Matrix(std::vector<std::vector<double>> t_matrix_vals)
{
    this->matrix_vals = t_matrix_vals;
    rows_n_cols();
}
Matrix::Matrix()
{
    
}
Matrix::Matrix(const Matrix& t_m)
{
    this->matrix_vals = t_m.matrix_vals;
    rows_n_cols();
}
void Matrix::operator=(const Matrix& t_m)
{
    this->matrix_vals = t_m.matrix_vals;
    this->rows = t_m.rows;
    this->cols = t_m.cols;
    rows_n_cols();
}
void Matrix::operator=(const std::vector<std::vector<double>> m)
{
    this->matrix_vals = m;
    rows_n_cols();
}


// [1, 3, 0, 4; 2, 1, 5, 0; 1, 3, 2, 5; 7, 6, 4, 8]
void Matrix::print()
{
    Matrix temp = *this;
    ++temp;
    for(auto const i : temp.matrix_vals){
        for(auto const j : i){
            std::cout << j << " ";
        }
        std::cout << "\n";
    }
}
std::ostream& operator <<(std::ostream& os, Matrix& m)
{
    Matrix temp = m;
    ++temp;
    for(auto const i : temp.matrix_vals)
    {
        for(auto const j : i)
        {
            os << j << " ";
        }
        os << "\n";
    }
    return os;
}

Matrix& Matrix::operator+=(const Matrix& m)
{
    for(int i = 0; i < cols; i++)
    {
        for(int j = 0; j < rows; j++)
        {
            matrix_vals[i][j] += m.matrix_vals[i][j];
        }
    }
    return *this;
}
Matrix& Matrix::operator+=(const double& d)
{
    for(int i = 0; i < cols; i++)
    {
        for(int j = 0; j < rows; j++)
        {
            matrix_vals[i][j] += d;
        }
    }
    return *this;
}
Matrix& Matrix::operator-=(const Matrix& m)
{
    for(int i = 0; i < cols; i++)
    {
        for(int j = 0; j < rows; j++)
        {
            matrix_vals[i][j] -= m.matrix_vals[i][j];
        }
    }
    return *this;
}
Matrix& Matrix::operator-=(const double& d)
{
    for(int i = 0; i < cols; i++)
    {
        for(int j = 0; j < rows; j++)
        {
            matrix_vals[i][j] -= d;
        }
    }
    return *this;
}
Matrix& Matrix::operator*=(const Matrix& m)
{
    for(int i = 0; i < cols; i++)
    {
        for(int j = 0; j < rows; j++)
        {
            matrix_vals[i][j] *= m.matrix_vals[i][j];
        }
    }
    return *this;
}
Matrix& Matrix::operator*=(const double& d)
{
    for(int i = 0; i < cols; i++)
    {
        for(int j = 0; j < rows; j++)
        {
            matrix_vals[i][j] *= d;
        }
    }
    return *this;
}
Matrix& Matrix::operator++(){
    Matrix temp = *this;
    Matrix temp2 = temp;
    for(int i = 0; i < cols; i++)
    {
        for(int j = 0; j < rows; j++)
        {
            temp2.matrix_vals[j][i] = temp.matrix_vals[i][j];
        }
    }
    *this = temp2;
    return *this;
}
Matrix operator+(const Matrix& m1, const Matrix& m2)
{
    Matrix temp(m1);
    return (temp += m2);
}
Matrix operator+(double d, const Matrix& m2)
{
    Matrix temp(m2);
    return (temp += d);
}
Matrix operator+(const Matrix& m1, double d)
{
    Matrix temp(m1);
    return (temp += d);
}
Matrix operator-(const Matrix& m1, const Matrix& m2)
{
    Matrix temp(m1);
    return (temp -= m2);
}
Matrix operator-(double d, const Matrix& m2)
{
    Matrix temp(m2);
    return (temp -= d);
}
Matrix operator-(const Matrix& m1, double d)
{
    Matrix temp(m1);
    return (temp -= d);
}
Matrix operator*(const Matrix& m1, const Matrix& m2)
{
    Matrix temp(m1);
    return (temp *= m2);
}
Matrix operator*(double d, const Matrix& m2)
{
    Matrix temp(m2);
    return (temp *= d);
}
Matrix operator*(const Matrix& m1, double d)
{
    Matrix temp(m1);
    return (temp *= d);
}
# endif
