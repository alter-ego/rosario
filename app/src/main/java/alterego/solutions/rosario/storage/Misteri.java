
package alterego.solutions.rosario.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "misterilist"
})
public class Misteri {

    @JsonProperty("name")
    private String name;
    @JsonProperty("misterilist")
    private List<String> misterilist = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Misteri() {
    }

    /**
     * 
     * @param misterilist
     * @param name
     */
    public Misteri(String name, List<String> misterilist) {
        this.name = name;
        this.misterilist = misterilist;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The misterilist
     */
    @JsonProperty("misterilist")
    public List<String> getMisterilist() {
        return misterilist;
    }

    /**
     * 
     * @param misterilist
     *     The misterilist
     */
    @JsonProperty("misterilist")
    public void setMisterilist(List<String> misterilist) {
        this.misterilist = misterilist;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
