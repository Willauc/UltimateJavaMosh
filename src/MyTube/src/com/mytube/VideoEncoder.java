package MyTube.src.com.mytube;

public class VideoEncoder implements iEncoder {
    @Override
    public void encode(Video video) {
        System.out.println("Encoding video...");
        System.out.println("Done!\n");
    }
}
