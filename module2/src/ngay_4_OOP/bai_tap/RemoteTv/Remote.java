package ngay_4_OOP.bai_tap.RemoteTv;

public class Remote {
    int channel;
    int volume;
    private Television television;
    private String option1;

    public Remote() {
    }

    public Remote(int channel, int volume) {
        this.channel = channel;
        this.volume = volume;
    }

    public void connectToTv (Television television) {
        this.television = television;
    }
    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void changeChannel(int channel) {
        this.channel = channel;
    }
    public void changeVolume(int volume) {
        this.volume = volume;
    }
    public void downUpVolumeByRemote(String option1) {
        this.option1 = option1;
        switch (this.option1) {
            case "up" :
                this.television.downUpVolume("up", getVolume());
                break;
            case "down" :
                this.television.downUpVolume("down", getVolume());
                break;
        }
    }



    @Override
    public String toString() {
        return "Remote{" +
                "channel=" + getChannel() +
                ", volume=" + getVolume() +
                '}';
    }
}
