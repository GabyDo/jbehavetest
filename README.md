#JBEHAVETEST

##Introduction
jbehavetest project is a demo: using jBehave framework to implement test case to open google home page and search for keyword ”JBehave” then verify the return result.

jBehave is a JBehave is a Java-based framework supporting Behaviour-Driven Development (BDD). For more information, please visit: https://jbehave.org/introduction.html

##Project structure
	There are three main parts:

	Stories: 
		Purpose: A story is a collection of scenarios, each detailing different examples of the behaviour of a given increment of functionality of the system.

		Location inside project: are stored at resources folder of project.

		Example: GoogleSerch.story.

	Mapping: 
		Purpose: Mapping Textual Scenario Steps to Java Methods via annotations.

		Location inside project: are stored under mapping package.

		Example: MappingStep class.

	Configure and run:
		Purpose: to configure Embeddable Java classes that allow the parsing and running of textual stories in many differenct ways.

		Location inside project: are stored under runner package.

		Example: SearchingStoreis class.



###Use

Prerequisites:

		IntelliJ IDE, and created a maven project.

Installation:

		- At POM file, add dependencies of: jbehave-core, selenium-chrome-driver, junit, webdrivermanager.
		
		- Add extension: From project setting, install plugin Jbehave support.	

How to run:

		Run test SearchingEmbedder.run().
