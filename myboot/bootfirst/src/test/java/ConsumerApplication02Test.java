import static org.junit.Assert.assertTrue;

import com.learn.Application;
import com.learn.controller.GreetingController;
import com.learn.controller.TestMessageController;
import com.learn.model.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple Application.
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ConsumerApplication02Test {

    @Autowired
    private GreetingController greetingController;
    @Autowired
    private TestMessageController testMessageController;

    @Test
    public void testGreeting() {
        Greeting greeting = this.greetingController.greeting("晨晨");
        System.err.println(greeting);
    }

    @Test
    public void testMessage() {
        System.err.println(this.testMessageController.message("张某人"));
    }
}
