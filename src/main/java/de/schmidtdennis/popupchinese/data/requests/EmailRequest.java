package de.schmidtdennis.popupchinese.data.requests;

import lombok.Data;

/**
 * EmailRequest
 */
@Data
public class EmailRequest {

    public String email;

    public Integer limit;

}