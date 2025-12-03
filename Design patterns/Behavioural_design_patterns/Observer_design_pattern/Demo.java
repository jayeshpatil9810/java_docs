package Behavioural_design_patterns.Observer_design_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws NumberFormatException, IOException {

        YoutubeChannel youtubeChannel = new YoutubeChannel();
        Subscriber jayesh = new Subscriber("Jayesh Patil");
        youtubeChannel.subscribe(jayesh);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Press 1 to upload video");
            System.out.println("Press 2 to create new subscriber");
            System.out.println("Press 3 to exit");

            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                // new video upload code
                System.out.println("Enter video title:");
                String videoTitle = br.readLine();
                youtubeChannel.newVideoUploaded(videoTitle);

            } else if (c == 2) {
                // create new subscriber
                System.out.println("Enter the name of subscriber:");
                String subName = br.readLine();
                Subscriber subscriber3 = new Subscriber(subName);
                youtubeChannel.subscribe(subscriber3);

            } else if (c == 3) {
                System.out.println("Thank you for using app");
                break;

            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
