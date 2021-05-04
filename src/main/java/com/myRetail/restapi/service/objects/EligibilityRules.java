
package com.myRetail.restapi.service.objects;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hold",
    "ship_to_guest"
})
public class EligibilityRules {

    @JsonProperty("hold")
    private Hold hold;
    @JsonProperty("ship_to_guest")
    private ShipToGuest shipToGuest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hold")
    public Hold getHold() {
        return hold;
    }

    @JsonProperty("hold")
    public void setHold(Hold hold) {
        this.hold = hold;
    }

    @JsonProperty("ship_to_guest")
    public ShipToGuest getShipToGuest() {
        return shipToGuest;
    }

    @JsonProperty("ship_to_guest")
    public void setShipToGuest(ShipToGuest shipToGuest) {
        this.shipToGuest = shipToGuest;
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
