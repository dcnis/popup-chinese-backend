package de.schmidtdennis.popupchinese.data.requests;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * EmailRequest
 */
@Data
public class UserLessonRequest {

    @NotNull(message = "email must not be null")
    private String email;

    @NotNull(message = "lessonId must not be null")
    private Integer lessonId;

    private Integer limit;

    private LocalDateTime lastSeen;

    private Boolean liked;

}