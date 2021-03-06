package io.oasp.module.test.common.base;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;

/**
 * This is the {@code abstract} base class for all tests. In most cases it will be convenient to extend this class. <br>
 * <br/>
 * Although it does not contain abstract methods, the class itself is declared {@code abstract} to clarify its purpose.
 * <br/>
 * <br/>
 * This class provides {@code final} methods {@link #setUp()} and {@link #tearDown()} which call {@code protected}
 * methods {@link #doSetUp()} and {@link #doTearDown()} internally. <br/>
 * Both methods {@link #doSetUp()} and {@link #doTearDown()} are left empty here. If some default behaviour is desired
 * during test setup or teardown these methods should be overridden by the subclass. <br/>
 * Implementations <b>must</b> call the super implementation. This call should always happen at the beginning of the
 * implementation. This helps to avoid confusion of call orders. <br/>
 * <br/>
 * The following listing should clarify the intention:
 *
 * <pre>
 * public class MyTest extends BaseTest {
 *
 *   &#64;Override
 *   protected void doSetUp() {
 *
 *     super.doSetUp();
 *     // ... my code
 *   }
 * }
 * </pre>
 *
 * @author shuber, jmolinar
 */
public abstract class BaseTest extends Assertions {
  /**
   * Indicates if the test class is to be set up for the first time. {@code true} indicates that the class has already
   * been set up (e.g., database setup) for the execution of an preceding test method.
   */
  protected static boolean INITIALIZED = false;

  /**
   * Suggests to use {@link #doSetUp()} method before each tests.
   */
  @Before
  public final void setUp() {

    // Simply sets INITIALIZED to true when setUp is called for the first time.
    doSetUp();
    if (!INITIALIZED) {
      INITIALIZED = true;
    }
  }

  /**
   * Suggests to use {@link #doTearDown()} method before each tests.
   */
  @After
  public final void tearDown() {

    doTearDown();
  }

  /**
   * @return {@code true} if this JUnit class is invoked for the first time (first test method is called), {@code false}
   *         otherwise (if this is a subsequent invocation).
   */
  protected boolean isInitialSetup() {

    return INITIALIZED;
  }

  /**
   * Provides initialization previous to the creation of the text fixture.
   */
  protected void doSetUp() {

  }

  /**
   * Provides clean up after tests.
   */
  protected void doTearDown() {

  }
}