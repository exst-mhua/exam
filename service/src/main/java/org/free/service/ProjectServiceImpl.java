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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

@Slf4j
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    //@PostConstruct
    private void init() {

    }

    private String dateToString(LocalDateTime date) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return date.format(formatter);
    }

    public void process() {

    }

}
