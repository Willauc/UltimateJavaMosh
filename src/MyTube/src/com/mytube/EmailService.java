package MyTube.src.com.mytube;

public class EmailService implements iCommunication{
    @Override
    public void sendNotification(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
