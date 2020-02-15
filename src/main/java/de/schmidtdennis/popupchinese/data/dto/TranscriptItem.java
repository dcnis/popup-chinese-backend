package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Entity;

import lombok.Data;

/**
 * TranscriptItem
 */

@Entity
@Data
public class TranscriptItem {

    public String line;
    public String pinyin;
    public String chinese;
    public String english;
    public String speaker;
    
}