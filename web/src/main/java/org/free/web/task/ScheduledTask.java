package org.free.web.task;

import org.free.api.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ScheduledTask {

    @Resource
    private ProjectService projectService;

    @Scheduled(cron = "${cron.project-planner}")
    public void projectTask() {
        projectService.process();
    }
}
