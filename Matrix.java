public class Matrix {
    private int n;
    private int m;
    private int[][] matrix_int;
    private Complex[][] matrix_c;
    private int flag;

    public Matrix(int n, int m, int flag, int[][] matrix) {
        this.n = n;
        this.m = m;
        this.flag = flag;
        this.matrix_int = new int[n][m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix_int[i][j] = matrix[i][j];
            }
        }
    }

    public Matrix(int n, int m, int flag, Complex[][] matrix) {
        this.n = n;
        this.m = m;
        this.flag = flag;
        this.matrix_c = new Complex[n][m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix_c[i][j] = new Complex(matrix[i][j].getA(), matrix[i][j].getB());
            }
        }
    }

    public Matrix(int n, int m, int flag) {
        this.n = n;
        this.m = m;
        this.flag = flag;
        this.matrix_c = new Complex[n][m];
        this.matrix_int = new int[n][m];
    }

    public boolean EqSize(Matrix m2) {
        return (this.m == m2.m) && (this.n == m2.n);
    }

    public void printMatrix() {
        if (this.flag == 1) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    System.out.print(matrix_int[i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
        } else {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    System.out.print(matrix_c[i][j].ComplexToString());
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }
    }

    public Matrix sum(Matrix m1, Matrix m2) throws MatrixSizeError {
        if (!(m1.EqSize(m2))) {
            throw new MatrixSizeError("Different sizes");
        } else {
            if (this.flag == 1) {
                Matrix new_m = new Matrix(m1.n, m2.m, 1);
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.m; j++) {
                        this.matrix_int[i][j] = m1.matrix_int[i][j] + m2.matrix_int[i][j];
                    }
                }
                return new_m;
            } else {
                Matrix new_m = new Matrix(m1.n, m2.m, 0);
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.m; j++) {
                        Complex c = new Complex();
                        c.SumComplex(m1.matrix_c[i][j], m2.matrix_c[i][j]);
                        this.matrix_c[i][j] = c;
                    }
                }
                return new_m;
            }
        }
    }

    public Matrix sub(Matrix m1, Matrix m2) throws MatrixSizeError {
        if (!(m1.EqSize(m2))) {
            throw new MatrixSizeError("Different sizes");
        } else {
            if (this.flag == 1) {
                Matrix new_m = new Matrix(m1.n, m2.m, 1);
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.m; j++) {
                        new_m.matrix_int[i][j] = m1.matrix_int[i][j] - m2.matrix_int[i][j];
                    }
                }
                return new_m;
            } else {
                Matrix new_m = new Matrix(m1.n, m2.m, 0);
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.m; j++) {
                        Complex c = new Complex();
                        c.SubComplex(m1.matrix_c[i][j], m2.matrix_c[i][j]);
                        new_m.matrix_c[i][j] = c;
                    }
                }
                return new_m;
            }
        }
    }

    public Matrix mul(Matrix m1, Matrix m2) throws MatrixSizeError {
        if (!(m1.m == m2.n)) {
            throw new MatrixSizeError("Different sizes");
        } else {
            if (this.flag == 1) {
                Matrix new_m = new Matrix(m1.n, m2.m, 1);
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.m; j++) {
                        int sum = 0;
                        for (int k = 0; k < m2.n; k++) {
                            sum += m1.matrix_int[i][k] * m2.matrix_int[k][j];
                        }
                        new_m.matrix_int[i][j] = sum;
                    }
                }
                return new_m;
            } else {
                Matrix new_m = new Matrix(m1.n, m2.m, 0);
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.m; j++) {
                        Complex sum = new Complex();
                        Complex mul = new Complex();
                        for (int k = 0; k < m2.n; k++) {
                            sum.SumComplex(mul.MultComplex(m1.matrix_c[i][k], m2.matrix_c[k][j]));
                        }
                        new_m.matrix_c[i][j] = sum;
                    }
                }
                return new_m;
            }
        }
    }

    public Matrix mul(Matrix m1, int num) {
        Matrix new_m;
        if (this.flag == 1) {
            new_m = new Matrix(m1.n, m1.m, 1);
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    new_m.matrix_int[i][j] = num * m1.matrix_int[i][j];
                }
            }
        } else {
            new_m = new Matrix(m1.n, m1.m, 0);
            Complex num_ = new Complex(num, 0);
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    new_m.matrix_c[i][j] = num_;
                }
            }
        }
        return new_m;
    }

    public Matrix Transp() {
        Matrix new_m = new Matrix(this.m, this.n, this.flag);
        if (this.flag == 1) {
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < this.n; j++){
                    new_m.matrix_int[i][j] = this.matrix_int[j][i];
                }
            }
        } else {
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < this.n; j++){
                    new_m.matrix_c[i][j] = this.matrix_c[j][i];
                }
            }
        }
        return new_m;
    }

    public void printDeter() throws MatrixSizeError {
        if (this.n != this.m) {
            throw new MatrixSizeError("Can not find determinant because of size");
        } else {
            if (this.flag == 1) {
                int deter = 0;
                int mul = 1;
                for (int i = 0; i < 3; i++) {
                    mul = 1;
                    int cur = i;
                    for(int j = 0; j < this.m; j++) {
                        if(cur >= this.m) {
                            cur = cur - this.n;
                        }
                        mul *= this.matrix_int[j][cur];
                        cur += 1;
                    }
                    deter += mul;
                }
                for (int i = 0; i < 3; i++) {
                    mul = 1;
                    int cur = i + this.m - 1;
                    for(int j = 0; j < this.m; j++) {
                        if(cur >= this.m) {
                            cur = cur - this.n;
                        }
                        if(cur < 0) {
                            cur = cur + this.n;
                        }
                        mul *= this.matrix_int[j][cur];
                        cur -= 1;
                    }
                    deter -= mul;
                }
                System.out.println(deter);
            } else {
                Complex deter = new Complex(0, 0);
                Complex mul = new Complex(1, 1);
                for (int i = 0; i < 3; i++) {
                    mul.set(1, 1);
                    int cur = i;
                    for(int j = 0; j < this.m; j++) {
                        if(cur >= this.m) {
                            cur = cur - this.n;
                        }
                        mul.MultComplex(this.matrix_c[j][cur]);
                        cur += 1;
                    }
                    deter.SumComplex(mul);
                }
                for (int i = 0; i < 3; i++) {
                    mul.set(1, 1);
                    int cur = i + this.m - 1;
                    for(int j = 0; j < this.m; j++) {
                        if(cur >= this.m) {
                            cur = cur - this.n;
                        }
                        if(cur < 0) {
                            cur = cur + this.n;
                        }
                        mul.MultComplex(this.matrix_c[j][cur]);
                        cur -= 1;
                    }
                    deter.SubComplex(mul);
                }
                System.out.println(deter.ComplexToString());
            }
        }
    }

    static class MatrixSizeError extends Exception {
        MatrixSizeError(String message){
            super(message);
        }
    }
}