package org.example.backend.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private int id;
    private int price;
    private OutboundLeg outboundLeg;
    private LocalDateTime quoteDateTime;

    @JsonProperty("QuoteId")
    public int getId() {
        return id;
    }

    @JsonProperty("QuoteId")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("MinPrice")
    public int getPrice() {
        return price;
    }

    @JsonProperty("MinPrice")
    public void setPrice(int price) {
        this.price = price;
    }

    @JsonProperty("OutboundLeg")
    public OutboundLeg getOutboundLeg() {
        return outboundLeg;
    }

    @JsonProperty("OutboundLeg")
    public void setOutboundLeg(OutboundLeg outboundLeg) {
        this.outboundLeg = outboundLeg;
    }

    @JsonProperty("QuoteDateTime")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime getQuoteDateTime() {
        return quoteDateTime;
    }

    @JsonProperty("QuoteDateTime")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setQuoteDateTime(LocalDateTime quoteDateTime) {
        this.quoteDateTime = quoteDateTime;
    }
}
