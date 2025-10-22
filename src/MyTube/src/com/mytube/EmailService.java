package MyTube.src.com.mytube;

public class EmailService implements iCommunication{
    public void sendNotification(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
