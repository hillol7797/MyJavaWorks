Suppose that we want to handle polynomials of degrees <= 100 and with integer coefficients. We need 101 int cells to store all the coefficients (of X0 through X100) of a polynomial. For enhanced efficiency one needs an additional cell to store the exact degree of a polynomial. The degree of the zero polynomial is conventionally taken to be minus infinity which, in turn, can be conveniently represented by -1. Thus one may define polynomials as follows:

#define MINUS_INFINITY -1    /* Any invalid (negative) degree will do */
#define MAX_DEGREE 100       /* We are interested in polynomials of max degree 100 */
#define POLY_SIZE 102        /* We need 102 int cells, 101 for storing the coefficients, one more for the degree */
#define DEGREE_INDEX 101     /* The degree is stored in the array cell with the highest index */

int f[POLY_SIZE], g[POLY_SIZE], h[POLY_SIZE];   /* f, g and h are to be treated as polynomials */

If the degree of f is d, then f[DEGREE_INDEX] holds the value d, f[i] stores the the coefficient of Xi for i=0,...,d. If d<100, the array locations f[i] for i=d+1,...,100 can hold arbitrary values; you don't need to initialize these to zeros. Since the degree d of a polynomial is stored, there is no need to consult coefficients of Xi for i>d.

Some examples are provided below. Here ? indicates any (uninitialized) value:
Representation of polynomials

Write the following functions to work with our polynomials:

/* Read a polynomial from the terminal. Your routine asks for the degree
   first and then reads the coefficients one by one. */
void polyScan ( int f[] ) ;

/* Print a polynomial to the terminal. Typical examples are:
   0
   -2
   X+1
   -3X+456
   2X^2-34X+5
   X^100+80X^80-60X^60-1
   We recommend you to suppress the zero coefficients and make your
   output look neater. */
void polyPrint ( int f[] ) ;

/* Evaluate a polynomial at a point. You must not use pow.
   Use Horner's rule for that, namely, evaluate the polynomial
   f(X) = anXn + an-1Xn-1 + ... + a1X + a0
   at an integer n as
   f(n) = (...((ann + an-1)n + an-2)n + ... + a1)n + a0 . */
int polyEval ( int f[] , int n ) ;   /* Return f(n) */

/* Compare two polynomials. Return 0 if the two polynomials are the same,
   1 otherwise. */
int polyComp ( int f[] , int g[] ) ;

/* Add two polynomials and store the result in a third one. Take care of
   zero polynomials as the operands as well as the result. Also take care
   of the situation that the output polynomial may be the same as one of
   the inputs. Thus calls like polyAdd(h,f,g) will be allowed and so are
   polyAdd(f,f,g) or polyAdd(f,f,f). */
void polyAdd ( int h[] , int f[] , int g[] ) ;  /* Assign f + g to h */

/* Multiply two polynomials. Again take care of zero polynomials and
   repetitions of arguments. */
void polyMul ( int h[] , int f[] , int g[] ) ;  /* Assign f * g to h */

/* Derivative of a polynomial. The output can be the same as the input. */
void polyDerive ( int h[] , int f[] ) ;         /* Assign f' to h */

The following three subroutines may prove to be handy for the working of the above routines. For the convenience of the students we provide implementations of the routines. This also exemplifies how to handle our polynomial data structure.

void polyInit ( int f[] )
{
   f[DEGREE_INDEX] = MINUS_INFINITY;
}

This routine initializes a polynomial to the zero polynomial. The degree is set to minus infinity. That's all!

void polyCompact ( int f[] )
{
   int d, i;

   d = MINUS_INFINITY;
   for (i=f[DEGREE_INDEX]; i>=0; i--) {
      if (f[i] != 0) { d = i; break; }
   }
   f[DEGREE_INDEX] = d;
}

This creates a compact representation of a polynomial. Note that the polynomial X2+3X+8 can also be represented as 0X3+X2+3X+8 or even as 0X100+0X99+...+0X3+X2+3X+8. Thus, for example, a typical session of polyScan could be the following:

Enter degree : 3
Enter coefficient of X^3 : 0
Enter coefficient of X^2 : 1
Enter coefficient of X^1 : 3
Enter coefficient of X^0 : 8

But we don't need the leading zeros which make arithmetic on polynomials inefficient. So one has to adjust the degree after discarding all leading zero coefficients.

The third auxiliary routine is for copying one polynomial to other. It makes a cell-by-cell copy of a polynomial array to another.

void polyCopy ( int h[] , int f[] )   /* Make a copy of f to h */
{
   int i;

   polyCompact(f);   /* optionally make f compact */
   h[DEGREE_INDEX] = f[DEGREE_INDEX];
   for (i=f[DEGREE_INDEX];i>=0;i--) h[i] = f[i];
}
