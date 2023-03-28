Following steps are used to create Fat Jar:
1) Make following changes in pom.xml file:
	a) Change packaging from war to jar in pom.xml file.
	   <packaging>jar</packaging>

	b) Add below plug-in in pom.xml file. Also set final jar file name.
	   <build>
		 <plugins>
		    <plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>	
		    </plugin>
		 </plugins>
		 <finalName>FormProcessing</finalName>
	   </build>

    c) Change boot version to 1.4.2.RELEASE
       <parent>
	   		<groupId>org.springframework.boot</groupId>
	   		<artifactId>spring-boot-starter-parent</artifactId>
	   		<version>1.4.2.RELEASE</version>
       </parent>
        
2) Remove web.xml from webapp/WEB-INF folder if exists.

3) Create META-INF/resources folders under src/main/resources
   Copy WEB-INF (along with views) folder from webapp to src/main/resources/META-INF/resources
   Remove webapp folder (optional)
   These steps are needed because of JSP Limitations with Embedded Tomcat Server.
   For more details, refer below two links:
   a) https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-jsp-limitations
   b) http://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-serve-dynamic/

4) Perform clean build and package project
    a) Maven clean
    b) Maven Build ...
         Goals: package
	 Optionally skip tests
  
6) Refresh project. Copy FormProcessing.jar from target folder to any folder in file path. (For example: D:\SPRING MICROSERVICES\Fat Jar\) 
 
7) Create table and sequence in Oracle DB
   CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
   CREATE SEQUENCE CUSTOMER_SEQ;
 
8) Navigate to above path in console and execute below command:
   D:\SPRING MICROSERVICES\Fat Jar>java -jar FormProcessing.jar
    
9) Finally test by using below URL:
   http://localhost:9090/customers/registration/form
   Note: By default boot deploys our project into ROOT context but not into our context. Hence project name (/FormProcessing) should not present in url.

    
    