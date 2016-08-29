package pl.enlight.thinkorganizer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import pl.enlight.thingorganizer.objects.dto.ThingDTO;
import pl.enlight.thingorganizer.service.ThingManagerService;
import pl.enlight.thinkorganizer.UnitTestUtils;
/**
 * Thing Manager controller methods testes
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ThingManagerControllerTest {
    private MockMvc mockMvc;

    /**
     * Configuration for this test
     */
    @Configuration
    public static class ContextConfiguration {
        @Bean
        public ThingManagerService manageService() {
            return mock(ThingManagerService.class);
        }
        @Bean
        public ThingManagerController thingManagerController() {
            return new ThingManagerController();
        }
    }

    @Inject
    private ThingManagerService manageService;
    @Inject
    private ThingManagerController thingManagerController;

    @Before
    public void setup() {
        this.mockMvc = UnitTestUtils.createMockMvcForController(thingManagerController);
    }

    /**
     * Test create method
     * @throws java.lang.Exception something exception, which should not occur
     */
    @Test
    public void testCreate() throws Exception {
        ThingDTO thingExpectedResult = new ThingDTO();
        thingExpectedResult.setId("1");
        thingExpectedResult.setName("Result");
        ThingDTO thingArgument = new ThingDTO();
        thingArgument.setName(thingExpectedResult.getName());
        when(manageService.create(thingArgument)).thenReturn(thingExpectedResult);
        
        ObjectMapper mapper = new ObjectMapper();
        String thingInJSON = mapper.writeValueAsString(thingArgument);
        ResultActions controllerResult = mockMvc.perform(post("/thing/manage/create")
                                         .contentType(UnitTestUtils.JSON_MEDIA_TYPE)
                                         .content(thingInJSON)
                                                        );
        controllerResult.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.name", is(thingExpectedResult.getName())))
        .andExpect(jsonPath("$.id", is(thingExpectedResult.getId())));
        verify(manageService, times(1)).create(thingArgument);
        verifyNoMoreInteractions(manageService);
    }
}
