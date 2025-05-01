import java.util.concurrent.atomic.AtomicBoolean;

public class CNCollision {
    private static final int NUM_NODES = 5;
    private static final AtomicBoolean medium = new AtomicBoolean(false);

    public static void main(String[] args) {
        for (int i = 0; i < NUM_NODES; i++) {
            new Thread(new Node(i)).start();
        }
    }

    static class Node implements Runnable {
        private final int id;

        public Node(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // Simulate some work before sending a packet
                    Thread.sleep((long) (Math.random() * 1000));

                    // Attempt to send a packet
                    if (medium.compareAndSet(false, true)) {
                        System.out.println("Node " + id + " is sending a packet...");
                        Thread.sleep(100); // Simulate packet transmission time
                        medium.set(false);
                        System.out.println("Node " + id + " finished sending a packet.");
                    } else {
                        System.out.println("Node " + id + " detected a collision and will retry...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}