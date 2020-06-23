package chaindemo;

import java.util.concurrent.LinkedBlockingDeque;

public class PrintProcessor extends Thread implements IRequestProcessor {
    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    private volatile boolean isFinish = false;

    public PrintProcessor() {
    }

    public void shutdown() {
        isFinish=true;
    }

    @Override
    public void run() {
        while (!isFinish) {
            try {
                Request request = requests.take();
                System.out.println("PrintProcessor: " + request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Request request) {
        requests.add(request);
    }
}
