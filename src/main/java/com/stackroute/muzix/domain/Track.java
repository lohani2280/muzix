package com.stackroute.muzix.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Document
@Data //Using lombok to handle the getter setters
@NoArgsConstructor //Creates a zero argument constructor
@AllArgsConstructor //Creates an all argument constructor
//@Builder

public class Track {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "ID of each track")
    private int trackID;
    @ApiModelProperty(value = "Name of each track")
    private String trackName;
    @ApiModelProperty(value = "Comments for each track")
    private String comments;
}
