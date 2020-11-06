class Car {

    int yearModel;
    String make;
    int speed;

    void brake() {
        if (this.speed - 5 >= 0) {
            this.speed -= 5;
        } else {
            this.speed = 0;
        }
    }

    void accelerate() {
        this.speed += 5;
    };
}
