
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
    "Medaglia",
    "Misteri",
    "decina",
    "introduzione"
})
public class WeekDay {

    @JsonProperty("Medaglia")
    private alterego.solutions.rosario.storage.Medaglia Medaglia;
    @JsonProperty("Misteri")
    private alterego.solutions.rosario.storage.Misteri Misteri;
    @JsonProperty("decina")
    private Decina decina;
    @JsonProperty("introduzione")
    private Introduzione introduzione;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Medaglia
     */
    @JsonProperty("Medaglia")
    public alterego.solutions.rosario.storage.Medaglia getMedaglia() {
        return Medaglia;
    }

    /**
     * 
     * @param Medaglia
     *     The Medaglia
     */
    @JsonProperty("Medaglia")
    public void setMedaglia(alterego.solutions.rosario.storage.Medaglia Medaglia) {
        this.Medaglia = Medaglia;
    }

    /**
     * 
     * @return
     *     The Misteri
     */
    @JsonProperty("Misteri")
    public alterego.solutions.rosario.storage.Misteri getMisteri() {
        return Misteri;
    }

    /**
     * 
     * @param Misteri
     *     The Misteri
     */
    @JsonProperty("Misteri")
    public void setMisteri(alterego.solutions.rosario.storage.Misteri Misteri) {
        this.Misteri = Misteri;
    }

    /**
     * 
     * @return
     *     The decina
     */
    @JsonProperty("decina")
    public Decina getDecina() {
        return decina;
    }

    /**
     * 
     * @param decina
     *     The decina
     */
    @JsonProperty("decina")
    public void setDecina(Decina decina) {
        this.decina = decina;
    }

    /**
     * 
     * @return
     *     The introduzione
     */
    @JsonProperty("introduzione")
    public Introduzione getIntroduzione() {
        return introduzione;
    }

    /**
     * 
     * @param introduzione
     *     The introduzione
     */
    @JsonProperty("introduzione")
    public void setIntroduzione(Introduzione introduzione) {
        this.introduzione = introduzione;
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
