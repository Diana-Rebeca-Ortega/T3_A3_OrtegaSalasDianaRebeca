import java.security.SecureRandom;

public class Producter implements Runnable {
	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;

	// constructor
	public Producter(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}

	@Override
	public void run() {
		int sum = 0;

		for (int count = 1; count <= 10; count++) {
			try { // sleep 0 to 3 seconds, then place value in Buffer
				
				Thread.sleep(generator.nextInt(3000)); // random sleep
				sharedLocation.blockingPut(count); //
				
				sum += count; // increment sum of values
				System.out.printf("\t%2d%n", sum);
			}
			catch (InterruptedException exepcion) {
				Thread.currentThread().interrupt();
			}

		}//for
		System.out.printf( "Producer done producing%nTerminating Producer%n");
	}//run
}//class