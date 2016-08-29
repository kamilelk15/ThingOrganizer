package pl.enlight.thinkorganizer;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Class with utils for Unit Test
 * @author Kamil Żur
 */
public class UnitTestUtils {
    /**
     * Media type for controller
     */
    public final static MediaType JSON_MEDIA_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype());

    /**
     * Create MockMvc for controller
     * @param controller application controller
     * @return object MockMvc for controller
     */
    public static MockMvc createMockMvcForController(Object controller) {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return MockMvcBuilders.standaloneSetup(controller).addFilters(filter).build();
    }
}
