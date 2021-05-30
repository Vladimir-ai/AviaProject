package com.example.aviaapplication.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {

    @SerializedName("placeId")
    @Expose
    private String placeId;

    @SerializedName("countryName")
    @Expose
    private String countryName;

    @SerializedName("cityId")
    @Expose
    private String cityId;

    @SerializedName("placeName")
    @Expose
    private String placeName;

}
