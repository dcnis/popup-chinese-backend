package de.schmidtdennis.popupchinese.data.dto;

import lombok.Data;

/**
 * TranscriptItem
 */

@Data
public class TranscriptItem {

    public String line;
    public String pinyin;
    public String chinese;
    public String english;
    public String speaker;
    
}