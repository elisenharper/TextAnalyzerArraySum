import java.util.Random;
import java.util.Scanner;

/**
 *
 * This class takes creates an array of the size given by the user and takes in
 * the amount of threads that the program will create to compute the sum in
 * parallel using the multiple threads.
 *
 */

public class ParallelSumThreads {

	private static final Random rand = new Random();

	/* Creates an array of inputed size with random numbers between 1 and 10.
	  randomNumbers is an array filled with numbers between 1 and 10 */

	public static int[] createRandomArray(int length) {
		int[] randomNumbers = new int[length];
		for (int i = 0; i < randomNumbers.length; i++) {
			randomNumbers[i] = rand.nextInt(10) + 1;
		}
		return randomNumbers;
	}

	/* Calculates the sum of the numbers of the inputed array by dividing the work
	  between the inputed number of threads and them sums them back together and
	  returns the result.

	  randomNumbers is the array filled with numbers between 1 and 10
	  numOfThreads is the number of threads which the method will use */

	public static int concurrentSum(int[] randomNumbers, int numOfThreads) {
		int len = (int) Math.ceil(1.0 * randomNumbers.length / numOfThreads);
		SumThread[] sumThread = new SumThread[numOfThreads];
		Thread[] threads = new Thread[numOfThreads];
		for (int i = 0; i < numOfThreads; i++) {
			sumThread[i] = new SumThread(randomNumbers, i * len, Math.min((i + 1) * len, randomNumbers.length));
			threads[i] = new Thread(sumThread[i]);
			threads[i].start();
		}
		try {
			for (Thread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		int total = 0;
		for (SumThread sums : sumThread) {
			total += sums.getTotalSum();
		}
		return total;
	}

	/* Main thread in which parameters are taken from the user, call all of the
	  methods and display the total sum and the time it took for both a multithread
	  version and the single thread version.

	  @param args an array of command-line arguments for the application. */

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int size = 0;

		while (true) {

			System.out.printf("Enter amount of random numbers to be summed: ");
			Scanner input = new Scanner(System.in);
			size = input.nextInt();

			System.out.printf("Enter number of threads: ");
			input = new Scanner(System.in);
			int numOfThreads = input.nextInt();

			int[] randomNumbers = createRandomArray(size);


			int total = 0;
			long startTime1 = System.nanoTime();
			total = concurrentSum(randomNumbers, numOfThreads);
			long endTime1 = System.nanoTime();

			System.out.println("\nNumber of Threads = " + numOfThreads);
			System.out.println("Number of elements: " + size);
			System.out.println("Sum: " + total);
			System.out.println("Total time: " + (endTime1 - startTime1) + " ns");


			long startTime2 = System.nanoTime();
			total = concurrentSum(randomNumbers, 1);
			long endTime2 = System.nanoTime();

			System.out.println("\nNumber of Threads = 1");
			System.out.println("Number of elements: " + size);
			System.out.println("Sum: " + total);
			System.out.println("Total time: " + (endTime2 - startTime2) + " ns \n");

		}
	}

}