# presto-event-logger
Presto EventLogger implementation that logs all the queries to a file

# How to use 

1. Get the code

    ```shell
    git clone https://github.com/dharmeshkakadia/presto-event-logger && cd presto-event-logger
    ```

2. Update the log4j config to your environment 
   
   ```shell
   vim src/main/resources/log4j.properties
   ```
   
3. Compile and package
   
   ```shell
   mvn package
   ```
   
4. Put the logger as part of presto

    ```shell
    cp target/presto-event-logger*.jar <path-to-presto>/plugin/event-logger/
    ```
    You should also copy ``slf4j-api-*.jar``, ``slf4j-log4j12-*.jar``, ``guava-*.jar``, ``log4j-*.jar`` to the event-logger folder ``<path-to-presto>/plugin/event-logger/``. 
    
5. Specify the event-logger as an event listener ``<path-to-presto>/etc/event-listener.properties``

    ``
    event-listener.name=event-logger
    ``

6. Start the presto server

    ```shell
    <path-to-presto>/bin/launcher start
    
    ```
