package org.free.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class Task implements Serializable {

    private Long id;
    private Long projectId;
    private String name;
    private String description;
    private Long durationInDays;
    private List<Task> dependsOn;
}
