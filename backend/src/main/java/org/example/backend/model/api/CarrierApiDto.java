package org.example.backend.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CarrierApiDto {
    private int id;
    private String name;

    @JsonProperty("CarrierId")
    public int getId() {
        return id;
    }

    @JsonProperty("CarrierId")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }
}
