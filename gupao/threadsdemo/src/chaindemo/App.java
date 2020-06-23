package chaindemo;

public class App {
    static IRequestProcessor preProcessor;

    public App() {
        PrintProcessor printProcessor = new PrintProcessor();
        printProcessor.start();

        SaveProcessor  saveProcessor = new SaveProcessor(printProcessor);
        saveProcessor.start();
        preProcessor = new PreProcessor(saveProcessor);
        ((PreProcessor) preProcessor).start();
    }

    public static void main(String[] args) {

        App app = new App();
        Request request = new Request();
        request.setName("jia");
        preProcessor.process(request);
    }
}
