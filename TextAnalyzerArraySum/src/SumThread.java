// Sum Thread class where the sum of the numbers within an array for the given array range.

public class SumThread implements Runnable {
	private int[] arrayOfNumbers;
	private int minIndex;
	private int maxIndex;
	private int totalSum;

	/* Constructor of the Sum Thread object in which it obtains the array and the
	 indexes for which it will carry out the sum.

	  arrayOfNumbers is the array filled with numbers between 1 and 10
	  minIndex is the minimum index of the range of the array for which the thread will sum.
	  maxIndex is the maximum index of the range of the array for which the thread will sum. */

	public SumThread(int[] arrayOfNumbers, int minIndex, int maxIndex) {
		this.arrayOfNumbers = arrayOfNumbers;
		this.minIndex = minIndex;
		this.maxIndex = maxIndex;
		this.totalSum = 0;
	}

	//Getter methods for the the totalSum value.

	// @return totalSum of the numbers in the specified ranges of the array.

	public int getTotalSum() {
		return this.totalSum;
	}

	/* Run method for the threads in which the numbers are summed from the
	 minimum range to the maximum range in the array.*/

	public void run() {
		this.totalSum = 0;
		for (int i = this.minIndex; i < this.maxIndex; i++) {
			this.totalSum += this.arrayOfNumbers[i];
		}
	}
}