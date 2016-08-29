package pl.enlight.thingorganizer.objects.dto;

import java.util.Objects;

/**
 * Object DTO representing thing
 * @author Kamil Żur
 */
public class ThingDTO {
    /**
     * Object ID
     */
    private String id;
    /**
     * Thing name
     */
    private String name; 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThingDTO{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ThingDTO other = (ThingDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
