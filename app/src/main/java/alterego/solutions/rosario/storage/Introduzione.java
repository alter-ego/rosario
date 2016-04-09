
package alterego.solutions.rosario.storage;

import java.util.HashMap;
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
    "croce",
    "granogrande",
    "granopiccolo"
})
public class Introduzione {

    @JsonProperty("croce")
    private String croce;
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
    public Introduzione() {
    }

    /**
     * 
     * @param granogrande
     * @param croce
     * @param granopiccolo
     */
    public Introduzione(String croce, String granogrande, String granopiccolo) {
        this.croce = croce;
        this.granogrande = granogrande;
        this.granopiccolo = granopiccolo;
    }

    /**
     * 
     * @return
     *     The croce
     */
    @JsonProperty("croce")
    public String getCroce() {
        return croce;
    }

    /**
     * 
     * @param croce
     *     The croce
     */
    @JsonProperty("croce")
    public void setCroce(String croce) {
        this.croce = croce;
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
