package pl.enlight.thingorganizer.service;

import pl.enlight.thingorganizer.objects.dto.ThingDTO;
import org.springframework.stereotype.Service;

/**
 * Service for managing things
 * @author Kamil Żur
 */
@Service
public interface ThingManagerService {
    
    /**
     * Create new thing in data source
     * @param thing object to create
     * @return created thing
     */
    public ThingDTO create(ThingDTO thing);
}
