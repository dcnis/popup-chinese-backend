package de.schmidtdennis.popupchinese.data.requests;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * TimestampRequest
 */
@Data
public class TimestampRequest {

    public Integer lessonId;

    public LocalDateTime lastSeen;

}