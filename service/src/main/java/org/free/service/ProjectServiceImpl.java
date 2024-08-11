package org.free.service;

import lombok.extern.slf4j.Slf4j;
import org.free.api.ProjectService;
import org.free.domain.entity.Project;
import org.free.domain.entity.Task;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

@Slf4j
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    private List<Project> projects;

    //@PostConstruct
    private void init() {
        //Setup test data here
        projects = new ArrayList<Project>();

        Project project1 =  new Project();
        project1.setId(1L);
        project1.setName("Project One");

        List<Task> project1Tasks = new ArrayList<Task>();

        Task project1task1 = new Task();
        project1task1.setId(1L);
        project1task1.setProjectId(1L);
        project1task1.setName("Task One of Project One");
        project1task1.setDurationInDays(2);
        projects.add(project1);

        List<Task> project1Task1Tasks = new ArrayList<Task>();

        Task project1task1subtask1 = new Task();
        project1task1subtask1.setId(2L);
        project1task1subtask1.setProjectId(1L);
        project1task1subtask1.setName("Sub Task One of Task One of Project One");
        project1task1subtask1.setDurationInDays(3);

        project1Task1Tasks.add(project1task1subtask1);
        project1task1.setDependsOn(project1Task1Tasks);
        project1Tasks.add(project1task1);
        project1.setTasks(project1Tasks);

        Project project2 =  new Project();
        project2.setId(2L);
        project2.setName("Project Two");

        List<Task> project2Tasks = new ArrayList<Task>();

        Task project2task1 = new Task();
        project2task1.setId(3L);
        project2task1.setProjectId(2L);
        project2task1.setName("Task One of Project Two");
        project2task1.setDurationInDays(5);

        project2Tasks.add(project2task1);
        project2.setTasks(project2Tasks);
        projects.add(project2);
    }

    private String dateToString(LocalDateTime date) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return date.format(formatter);
    }

    public void process() {
        //Assumptions:
        //All project can start at the same time
        //All task can start at the same time as long as they don't depend on something
        //No Task overlap with other project
        //No Task that will loop

        init();

        log.warn("===== Records to be process =====");
        for (Project project : projects) {
            log.warn("\n===== ===== ===== =====");
            log.warn("Project Name: " + project.getName());
            log.warn("Project Start Date: " + project.getStart());
            log.warn("Project End Date: " + project.getEnd());

            project.setStart(LocalDateTime.now());

            int longestDuration = 0;
            for (Task task : project.getTasks()) {
                if (task.getDependsOn() != null && !task.getDependsOn().isEmpty()) {

                } else {
                    if (longestDuration < task.getDurationinDays()) {
                        longestDuration = task.getDurationinDays();
                    }
                }
            }

            project.setEnd(LocalDateTime.now().plusDays(longestDuration));

            log.warn("===== ===== ===== =====");
            log.warn("After processing");
            log.warn("===== ===== ===== =====");
            log.warn("Project Name: " + project.getName());
            log.warn("Project Start Date: " + project.getStart());
            log.warn("Project End Date: " + project.getEnd());
        }
    }
}
