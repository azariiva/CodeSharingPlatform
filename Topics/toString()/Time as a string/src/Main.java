class Time {

    private static String FORMAT_STRING = "%02d:%02d:%02d";

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format(FORMAT_STRING, hours, minutes, seconds);
    }
}
