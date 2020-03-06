package de.schmidtdennis.popupchinese.data.requests;

import lombok.Data;

/**
 * EmailRequest
 */
@Data
public class UserLessonRequest {

    public String email;

    public Integer limit;

    public Integer lessonId;

}