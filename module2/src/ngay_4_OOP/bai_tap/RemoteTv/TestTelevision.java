package ngay_4_OOP.bai_tap.RemoteTv;

import java.util.Scanner;

public class TestTelevision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Remote remote = new Remote();
        Television tv = new Television();
        remote.connectToTv(tv);
        tv.setStatus(true);
        System.out.println(tv);
        System.out.print("Enter channel to change: ");
        remote.changeChannel(scanner.nextInt());
        //remote.setChannel(scanner.nextInt());
        System.out.print("Enter volume to change: ");
        //remote.setVolume(scanner.nextInt());
        remote.changeVolume(scanner.nextInt());
        System.out.print("Do you want to choose 'up' or 'down' volume? ");
        remote.downUpVolumeByRemote(scanner.next());
        System.out.println("TV's channel now: " + remote.getChannel() + " volume: " + tv.getVolume1());
        tv.setStatus(false);
        System.out.println(tv);
    }
}
