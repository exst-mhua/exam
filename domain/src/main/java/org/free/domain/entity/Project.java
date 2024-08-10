package org.free.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Project implements Serializable {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<Task> tasks;
}
