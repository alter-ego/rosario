
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
    "introduzione",
    "decina",
    "misteri",
    "medaglia"
})
public class WeekDay {

    @JsonProperty("introduzione")
    private Introduzione introduzione;
    @JsonProperty("decina")
    private Decina decina;
    @JsonProperty("misteri")
    private Misteri misteri;
    @JsonProperty("medaglia")
    private Medaglia medaglia;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeekDay() {
    }

    /**
     * 
     * @param decina
     * @param misteri
     * @param introduzione
     * @param medaglia
     */
    public WeekDay(Introduzione introduzione, Decina decina, Misteri misteri, Medaglia medaglia) {
        this.introduzione = introduzione;
        this.decina = decina;
        this.misteri = misteri;
        this.medaglia = medaglia;
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
     *     The misteri
     */
    @JsonProperty("misteri")
    public Misteri getMisteri() {
        return misteri;
    }

    /**
     * 
     * @param misteri
     *     The misteri
     */
    @JsonProperty("misteri")
    public void setMisteri(Misteri misteri) {
        this.misteri = misteri;
    }

    /**
     * 
     * @return
     *     The medaglia
     */
    @JsonProperty("medaglia")
    public Medaglia getMedaglia() {
        return medaglia;
    }

    /**
     * 
     * @param medaglia
     *     The medaglia
     */
    @JsonProperty("medaglia")
    public void setMedaglia(Medaglia medaglia) {
        this.medaglia = medaglia;
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
