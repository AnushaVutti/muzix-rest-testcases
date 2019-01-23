package com.stackroute.domain;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Track")
@Data
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private String comments;

}
