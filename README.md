# SpringProject

Link-uri utile:

Loading multiple contexts into Spring : http://blog.codehangover.com/load-multiple-contexts-into-spring/
- using classpath : classpath*:/beans*.xml

Pentru conexiunea la baza de date dintr-un proiect Spring este nevoie de :
- in pom.xml
<!-- MySQL -->
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.37</version>
	</dependency>

	<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-jdbc</artifactId>
		<version>2.0.6</version>
	</dependency>
	
	
	
Web app using Spring and Hibernate
- http://elizabetht.github.io/blog/2013/11/21/student-enrollment-using-hibernate-with-spring/

Spring + Hibernate web app using Xml configuration 
- http://www.codejava.net/frameworks/spring/spring-4-and-hibernate-4-integration-tutorial-part-1-xml-configuration

Bootstrap themes
- http://bootswatch.com/

Hibernate User Guide
- http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html

Registration in Spring Security and how to declare Validators
- https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/

Usefull tutorial on how to manually commit transactions on several tables
- http://javahonk.com/spring-programmatic-transactions-by-platformtransactionmanager

Tutorial Spring Security + MySql + Hibernate (service, dao, controller layers)
- http://fruzenshtein.com/spring-mvc-security-mysql-hibernate/

Good example on how to create your own custom UserDetailsService
- https://gist.github.com/esfand/6811882#how-to-use-custom-dao-class-in-spring-security
*GrantedAuthorityImpl was replaced by SimpleGrantedAuthority in Spring Security 4

How to solve the LazyInitializationException :
- http://www.harezmi.com.tr/blogpost497-Hibernate-s-New-Feature-For-Overcoming-Frustrating-LazyInitializationExceptions

Custom authentication in Spring Security - Java Configuration
- http://www.ekiras.com/2016/04/authenticate-user-with-custom-user-details-service-in-spring-security.html

Security Spring project with Java configuration
- https://github.com/Fruzenshtein/security-spr

How to use Hibernate Named Queries
- http://www.journaldev.com/3451/hibernate-named-query-example-namedquery

Bootstrap 3 dialog:
- https://github.com/nakupanda/bootstrap3-dialog

Spring MVC with Ajax and JQuery
- http://fruzenshtein.com/spring-mvc-ajax-jquery/
