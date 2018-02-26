package util.time;

public final class Sleep {

    public static void forMs(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }
}
