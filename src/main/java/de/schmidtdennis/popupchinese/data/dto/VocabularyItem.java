package de.schmidtdennis.popupchinese.data.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VocabularyItem implements Serializable {

    public Integer id;
    public String typ;
    public String pinyin; 
    public String chinese;
    public String english;

}
