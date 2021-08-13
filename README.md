# Concordance Mapping
## System Setup: 
## Java
#### Install Java 11 or higher from here: https://www.oracle.com/java/technologies/javase-jdk16-downloads.html
#### Configure Environment Variables: 
##### JAVA_Home within System Variables points to 

`C: ~\jdk-11.0.12`

<img src = "./JAVA_HOME.jpeg"/>

##### JAVA_Home within the System Variables path variable

`C: ~\jdk-11.0.12\bin`

<img src = "./javaEnvironmentPathToBin.jpg"/>

##### Verify Java Installation and Environment Variable Setup through CLI:
`java --version`
##### It should show the java version: 
<img src = "./javaVersion.jpg" />

## Maven
#### Install Maven From Here: https://maven.apache.org/download.cgi
#### Configure Environment Variables: 
##### Within the Path System Variable Add A New Path to point to the bin folder of the unzipped download file from the maven download: 
<img src = "./mavenEnvVariable.jpg"/>

##### Verify Maven Installation and Environment Variable Setup through CLI:
`mvn -v`

<img src = "./mvnVerfification.jpg"/>

# Compile:
### cd into parent directory
`mvn package`

# Run the application:
from the ~\my-app directory

`java -cp target/my-app-1.0-SNAPSHOT.jar path.to.mainclass fileName.txt`

the test file test1.txt is included in the repository 

`java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App test1.txt`


<img src = "./concordance.jpg"/>




