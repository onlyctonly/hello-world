package chaindemo;

import java.util.concurrent.LinkedBlockingDeque;

public class SaveProcessor extends Thread implements IRequestProcessor {
    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public SaveProcessor() {
    }

    public SaveProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void shutdown() {
        isFinish=true;
    }

    @Override
    public void run() {
        while (!isFinish) {
            try {
                Request request = requests.take();
                System.out.println("SaveProcessor: " + request);
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Request request) {
        requests.add(request);
//        nextProcessor.process(request);
    }
}
