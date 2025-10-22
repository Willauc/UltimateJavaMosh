package MyTube.src.com.mytube;

public class VideoProcessor {
    private final iEncoder encoder;
    private final iDatabase database;
    private final iCommunication communicator;

    public VideoProcessor(iEncoder encoder, iDatabase database, iCommunication communicator) {
        this.encoder = encoder;
        this.database = database;
        this.communicator = communicator;
    }

    public void process(Video video) {
        encoder.encode(video);

        database.store(video);

        communicator.sendNotification(video.getUser());
    }
}

