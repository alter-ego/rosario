
package alterego.solutions.rosario.storage;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "granogrande",
    "granopiccolo"
})
public class Decina {

    @JsonProperty("granogrande")
    private String granogrande;
    @JsonProperty("granopiccolo")
    private String granopiccolo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Decina() {
    }

    /**
     * 
     * @param granogrande
     * @param granopiccolo
     */
    public Decina(String granogrande, String granopiccolo) {
        this.granogrande = granogrande;
        this.granopiccolo = granopiccolo;
    }

    /**
     * 
     * @return
     *     The granogrande
     */
    @JsonProperty("granogrande")
    public String getGranogrande() {
        return granogrande;
    }

    /**
     * 
     * @param granogrande
     *     The granogrande
     */
    @JsonProperty("granogrande")
    public void setGranogrande(String granogrande) {
        this.granogrande = granogrande;
    }

    /**
     * 
     * @return
     *     The granopiccolo
     */
    @JsonProperty("granopiccolo")
    public String getGranopiccolo() {
        return granopiccolo;
    }

    /**
     * 
     * @param granopiccolo
     *     The granopiccolo
     */
    @JsonProperty("granopiccolo")
    public void setGranopiccolo(String granopiccolo) {
        this.granopiccolo = granopiccolo;
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
