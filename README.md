Project Summary:

1. We need to calculate calendar schedules for project plans
2. Each project plan consists of tasks. Every task has a certain duration.
3. A task can depend on zero or more other tasks. If a task depends on some other tasks, it can only be started after these tasks are completed
4. So, for a set of tasks (with durations and dependencies), the solution for the challenge should generate a schedule, i.e. assign Start and End Dates for every task
5. It is ok to have a console app

How to build:

1. using maven and Java 8 minimum
2. run the following command: mvn clean install

How to run:

1. After building the project, go to the directory web/target
2. There grab the web-1.0-SNAPSHOT.zip
3. Extract the files
4. run the program using the following command: java -jar web.jar
