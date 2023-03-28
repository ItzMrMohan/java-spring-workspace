The following steps are needed to build war project by using spring boot and then deploy into External Server:
1) Make following changes in pom.xml file:
   a) Change packaging from jar to war in pom.xml file.
	  <packaging>war</packaging>
	  
   b) Change boot version to 1.5.x.RELEASE (optional)
      <version>1.5.9.RELEASE</version>
      	
   c) Exclude embedded tomcat
      <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		
   d) The 'tomcat-embed-jasper' dependency is not needed in case of external server.
      <!-- <dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
      </dependency> -->
      
   e) Add servlet-api maven dependency with 'provided' scope
      <dependency>
			<groupId>servletapi</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.4</version>
			<scope>provided</scope>
	    </dependency>
	    Note: We will have to mark the scope of servlet-api dependency as 'provided' so that it will not be shipped with the WAR file.
	    
   f) Remove 'spring-boot-maven-plugin' because it is needed in case of Fat jar but not in case of war archiving.
      <plugin>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
   
   g) Set war file name as below:
      <finalName>FormProcessing</finalName>
    
2)  Initializing spring in the web application context by using the 'SpringBootServletInitializer' from spring library. 
    By extending and overriding the configure(SpringApplicationBuilder application) of this method, 
    We can inform spring to load our boot class also to be added to the spring web application context. 
    package edu.aspire.test;

    import org.springframework.boot.web.support.SpringBootServletInitializer;
    import org.springframework.boot.builder.SpringApplicationBuilder;
    
    @SpringBootApplication(scanBasePackages = {"edu.aspire.config"})
    public class Application extends SpringBootServletInitializer{
	    /*public static void main(String[] args) {
		   SpringApplication.run(Application.class, args);
	    }*/
	
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		   return application.sources(Application.class);
	    }
    }

3) Create 'webapp' folder, if it doesn't exist, under src/main.
   Copy WEB-INF (along with views) folder from 'src/main/resources/META-INF/resources' to webapp folder.

4) Optionally we can remove MET-INF folder from src/main/resources.  
 
5) Add our context root '/FormProcessing' to form action in webapp/WEB-INF/views/NewCustomer.jsp file:
    <sf:form action="/FormProcessing/customers/create" method="POST" modelAttribute="customer">
    ...
    
6) Remove 'server.port' property from application.properties file.
  
7) Perform clean build and package project
    a) Maven clean
    b) Maven Build ...
         Goals: package
         optionally Skip Tests
8) Refresh project. Copy target/FormProcessing.war to any external server such as external tomcat #TOMCAT_HOME/webapps/FormProcessing.war
 
9) Start external server
   Goto #TOMCAT_HOME/bin --double click on--> Tomcat8.exe 
    
10) Create table and sequence in Oracle DB
    CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
    CREATE SEQUENCE CUSTOMER_SEQ;
    
11) Finally test by using below url:
    http://localhost:9090/FormProcessing/customers/registration/form
    
    
Note: For more details refer https://springhow.com/convert-spring-boot-jar-in-to-war/

You may get below error. To fix this error refer below link:
Cannot change version of project facet Dynamic Web Module to 3.1
Ref: https://www.admfactory.com/how-to-fix-cannot-change-version-of-project-facet-dynamic-web-module-to-3-1-error-in-eclipse/
  
  
 
