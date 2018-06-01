
public class App {

	public static void main(String[] args) {
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
	        public void run() {
	            try {
	                Thread.sleep(200);
	                System.out.println("Shouting down ...");

		            System.out.println("i am done");

	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    });
		

		System.out.println("i am running");
	}

}
