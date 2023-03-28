The actuator provides us insight about spring project such as:
   1) Total list of beans have been configured for our spring project which includes:
		a) Explicitly configured beans by developer.
		b) Auto discovered beans by spring.
		c) Auto Configured beans by spring boot.
		d) Bean dependencies information.

   2) Provides auto configuration report which contains both Positive and Negative matches.

   3) Provides project environment such as path, classpath, etc

   4) Provides health status such as up or down.

   5) Provides project metrics such as CPU usage, Memory usage, etc
   ...

The following steps are needed to get boot actuator feature:
1) The following starter dependency should be added in pom.xml file:
   <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	
2) Turn ON spring security to restrict actuators end points access
   management.security.enabled=true
   Note: Change boot version from 1.4.2.RELEASE to 1.5.x.RELEASE (optional)
   
   There was an unexpected error (type=Unauthorized, status=401).
   Full authentication is required to access this resource.
   
3) Following steps are needed to access actuator end points by authorized person:
   a) Add starter-security dependency in pom.xml file.
      <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
	  </dependency>
   b) Add @EnableWebSecurity in boot strap file (such as Application.java) 	 
      The above annotation automatically provides default login pop-up (but not login page).
    
   c) Add below properties in application.properties file:
      security.user.name=aspire
      security.user.password=aspire123
      