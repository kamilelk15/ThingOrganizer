package pl.enlight.thinkorganizer.controller;

import javax.inject.Inject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.enlight.thingorganizer.objects.dto.ThingDTO;
import pl.enlight.thingorganizer.service.ThingManagerService;

/**
 * Controller for managing things
 * @author Kamil Żur
 */
@RestController
@RequestMapping("/thing/manage")
public class ThingManagerController {
     
    @Inject
    private ThingManagerService manageService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ThingDTO create(@RequestBody ThingDTO thingDTO) {
        return manageService.create(thingDTO);
    }
}
