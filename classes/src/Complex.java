
public class Complex {
    private double real = 0;
    private double imaginary = 0;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public String getComplex(){
        final String operator = this.imaginary < 0 ? " - " : " + ";
        return  "" + this.real + operator +(this.imaginary < 0 ? -this.imaginary : this.imaginary)+ "i";
    };


    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public void add(Complex that) {
        real += that.real;
        imaginary += that.imaginary;
    }

    public void sub(Complex that) {
        real -= that.real;
        imaginary -= that.imaginary;
    }

    public void mul(Complex that) {
        double new_re = this.real*that.real - this.imaginary*that.imaginary;
        double new_im = this.real*that.imaginary + this.imaginary*that.real;
        real = new_re;
        imaginary = new_im;
    }

    public Complex mul(Complex that, Complex that1) {
        double new_re = that1.real*that.real - that1.imaginary*that.imaginary;
        double new_im = that1.real*that.imaginary + that1.imaginary*that.real;
        return new Complex(new_re, new_im);
    }

    public void div(Complex that) {
        Complex thatConj = conjugate(that);
        Complex divisor = mul(this, thatConj);
        Complex remainder = mul(that, thatConj);
        double remainderRes = remainder.real + remainder.imaginary;
        this.real = divisor.real / remainderRes;
        this.imaginary = divisor.imaginary / remainderRes;
    }

    public void conjugate() {
        imaginary = -imaginary;
    }

    public Complex conjugate(Complex that) {
        return new Complex(that.real, -that.imaginary);
    }

    public void reciprocate() {
        final double absolute = abs();
        conjugate();
        imaginary = this.imaginary / (absolute * absolute);
        real = this.real / (absolute * absolute);
    }

    public void WriteLineComplex() {
        final String operator = this.imaginary < 0 ? " - " : " + ";
        String real = String.valueOf(this.real);
        String imaginary = String.valueOf(this.imaginary < 0 ? -this.imaginary : this.imaginary);
        System.out.println(real+operator+imaginary+"i");
    }

    public void WriteLineComplex(Complex that) {
        final String operator = this.imaginary < 0 ? " - " : " + ";
        String real = String.valueOf(that.real);
        String imaginary = String.valueOf(this.imaginary < 0 ? -this.imaginary : this.imaginary);
        System.out.println(real+operator+imaginary+"i");
    }
}
