rmdir /S /Q %~dp0result
rmdir /S /Q %~dp0logs

java -javaagent:%~dp0jacoco-0.8.2\jacocoagent.jar=destfile=%~dp0result\fuck.exec,classdumpdir=%~dp0result\class\,includes=com.firelord.*,output=tcpserver,port=8457,address=127.0.0.1 -jar %~dp0..\core-fw-spring-test\target\core-fw-spring-test-0.0.1-SNAPSHOT.jar
