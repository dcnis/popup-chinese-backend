package de.schmidtdennis.popupchinese.data.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * DifficultyBody
 */
@Data
public class DifficultyRequest {

    @JsonProperty("difficulty")
    public Integer difficulty;

}