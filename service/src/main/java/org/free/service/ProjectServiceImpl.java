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
        project1.setId(1);
        project1.setName("Project One");

        List<Task> tasks = new ArrayList<Task>();

        Task project1task1 = new Task();
        project1task1.setId(1);
        project1task1.setProjectId(1);
        project1task1.setName("Task One of Project One");
        project1task1.setDurationsInDays(2);

        Task project1task1subtask1 = new Task();
        project1task1subtask1.setId(2);
        project1task1subtask1.setProjectId(1);
        project1task1subtask1.setName("Sub Task One of Task One of Project One");
        project1task1subtask1.setDurationsInDays(3);
    }

    private String dateToString(LocalDateTime date) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return date.format(formatter);
    }

    public void process() {
        //Process data here
        //Assumptions:
        //No Task overlap with other project
        //No Task that will loop
    }
}
