
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Test suite for all the unit tests for the ParallelArraySum project.

@RunWith(Suite.class)
@SuiteClasses({ ParallelSumThreadsTest.class, SumThreadTest.class })
public class AllTests {

}