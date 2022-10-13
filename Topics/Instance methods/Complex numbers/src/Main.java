class Complex {

    double real;
    double image;

    public void add(Complex num) {
        real += num.real;
        image += num.image;
    }

    public void subtract(Complex num) {
        real -= num.real;
        image -= num.image;
    }
}