
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
    "is_assortment",
    "is_kit_master",
    "is_standard_item",
    "is_component"
})
public class BundleComponents {

    @JsonProperty("is_assortment")
    private Boolean isAssortment;
    @JsonProperty("is_kit_master")
    private Boolean isKitMaster;
    @JsonProperty("is_standard_item")
    private Boolean isStandardItem;
    @JsonProperty("is_component")
    private Boolean isComponent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_assortment")
    public Boolean getIsAssortment() {
        return isAssortment;
    }

    @JsonProperty("is_assortment")
    public void setIsAssortment(Boolean isAssortment) {
        this.isAssortment = isAssortment;
    }

    @JsonProperty("is_kit_master")
    public Boolean getIsKitMaster() {
        return isKitMaster;
    }

    @JsonProperty("is_kit_master")
    public void setIsKitMaster(Boolean isKitMaster) {
        this.isKitMaster = isKitMaster;
    }

    @JsonProperty("is_standard_item")
    public Boolean getIsStandardItem() {
        return isStandardItem;
    }

    @JsonProperty("is_standard_item")
    public void setIsStandardItem(Boolean isStandardItem) {
        this.isStandardItem = isStandardItem;
    }

    @JsonProperty("is_component")
    public Boolean getIsComponent() {
        return isComponent;
    }

    @JsonProperty("is_component")
    public void setIsComponent(Boolean isComponent) {
        this.isComponent = isComponent;
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
