1) Make following changes in pom.xml file:
   a) Change packaging from jar to war in pom.xml file.
	  <packaging>war</packaging>
	
   b) Add spring-boot-starter-tomcat dependency explicitly with 'provided' scope.
	  <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
	  </dependency>
	  Note: We will have to mark the starter-tomcat as 'provided' so that it will not be shipped with the WAR file.
	
   c) The 'tomcat-embed-jasper' dependency is not need in case of war deployment.
      <!-- <dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
      </dependency> -->
   
   d) Set project name as below:
      <finalName>SpringMVC</finalName>
    
 2) Initializing spring in the web application context by using the 'SpringBootServletInitializer' from spring library. 
    By extending and overriding the configure(SpringApplicationBuilder application) of this method, 
    We can inform spring to load our boot class also to be added to the spring web application context. 
	package edu.aspire.test;

    import org.springframework.boot.builder.SpringApplicationBuilder;
    import org.springframework.boot.web.support.SpringBootServletInitializer;

    @SpringBootApplication(scanBasePackages = {"edu.aspire.config"})
    @EnableWebSecurity
    public class Application extends SpringBootServletInitializer{
	    public static void main(String[] args) {
		   SpringApplication.run(Application.class, args);
	    }
	
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		   return application.sources(Application.class);
	    }
    }
 
 3) Add our context root '/FormProcessing' in form action.
    <form action="/SpringMVC/nc.htm" method="POST">
    ...

4) Remove 'server.port' property from application.properties file 
 
5) Perform clean build
    a) Maven clean
    b) Maven Build ...
         Goal: package
  
6) Copy target/SpringMVC.war to external tomcat #TOMCAT_HOME/webapps/SpringMVC.war
 
7) Create table and sequence
    CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
    CREATE SEQUENCE CUSTOMER_SEQ;
    
8) Finally test by using below url:
    http://localhost:9090/SpringMVC/NewCustomer.jsp
    
  
  Note: For more details refer https://springhow.com/convert-spring-boot-jar-in-to-war/
  
  Cannot change version of project facet Dynamic Web Module to 3.1
  Ref: https://www.admfactory.com/how-to-fix-cannot-change-version-of-project-facet-dynamic-web-module-to-3-1-error-in-eclipse/
  
 
