
class Circle {

    double radius;

    double getLength() {
        return 2 * Math.PI * radius;
    }

    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}