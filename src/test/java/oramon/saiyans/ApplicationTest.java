package oramon.saiyans;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(
        classes = ProfileApplication.class,
        loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
public class ApplicationTest {


}
