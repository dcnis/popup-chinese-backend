package de.schmidtdennis.popupchinese.data.dto;

import lombok.Data;

@Data
public class VocabularyItem {

    public Integer id;
    public String typ;
    public String pinyin; 
    public String chinese;
    public String english;

}
