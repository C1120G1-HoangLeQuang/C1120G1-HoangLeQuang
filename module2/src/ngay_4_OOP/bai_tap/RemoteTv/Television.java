package ngay_4_OOP.bai_tap.RemoteTv;

import java.util.Scanner;

public class Television extends Remote{
    int chanel1 = 3;
    int volume1 = 4;
    boolean status;

    public Television() {
    }

    public Television(int chanel1, int volume1, boolean status) {
        this.chanel1 = chanel1;
        this.volume1 = volume1;
        this.status = status;
    }

    public int getChanel1() {
        return chanel1;
    }

    public void setChanel1(int chanel1) {
        this.chanel1 = chanel1;
    }

    public int getVolume1() {
        return volume1;
    }

    public void setVolume1(int volume1) {
        this.volume1 = volume1;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void downUpVolume(String option, int volume) {
        if (option == "up") {
            this.volume1 += volume;
        } else if (option == "down") {
            if (volume > this.volume1) {
                System.out.print("Volume is over to down");
                this.volume1 -= this.volume1;
            } else {
                this.volume1 -= volume;
            }
        }
    }
    @Override
    public String toString() {
        if (isStatus()) {
            return "Tv{" +
                    "TV is on" +
                    " channel= " + getChanel1() +
                    ", volume= " + getVolume1() +
                    '}';
        } else {
            return "TV is off";
        }
    }
}
