package ngay_4_OOP.bai_tap;

public class StopWatch {
    private double starTime;
    private  double endTime;

    public StopWatch() {
    }

    public double getStarTime() {
        return starTime;
    }

    public void setStarTime(double starTime) {
        this.starTime = starTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }
    public void start() {
        this.starTime = System.currentTimeMillis();
    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public double getElapsedTime() {
        return this.endTime - this.starTime;
    }
}
