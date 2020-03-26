import static org.junit.Assert.*;

import org.junit.Test;

// Unit test class to test the methods of the SumThread class.

public class SumThreadTest {

	@Test
	/*Unit test for all the methods in the Sum thread class. It includes the .run()
	  and .getTotalSum() methods */

	public void test() {

		int[] arrayOfNumbers = { 1, 2, 3, 4, 5, 6 };
		SumThread sumThread = new SumThread(arrayOfNumbers, 0, 6);
		sumThread.run();
		assertEquals(21, sumThread.getTotalSum());
	}

}
