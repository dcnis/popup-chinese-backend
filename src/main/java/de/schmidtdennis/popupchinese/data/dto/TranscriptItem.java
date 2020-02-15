package de.schmidtdennis.popupchinese.data.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * TranscriptItem
 */

@Data
public class TranscriptItem implements Serializable {

    public String line;
    public String pinyin;
    public String chinese;
    public String english;
    public String speaker;
    
}