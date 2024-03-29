# TB_Challenge
This is a personal challenge project, whose purpose is to build a web service that exposes Vehicle (Bus), Fleet (Operator) and Activity (Stop) data, for a given time frame.

The service exposes a RESTful API to answer the following questions:

1.    Given a time frame [start-time, end-time], what is the list of running operators?

2.    Given a time frame [start-time, end-time] and an Operator, what is the list of vehicle IDs?

3.    Given a time frame [start-time, end-time] and a fleet, which vehicles are at a stop?

4.    Given a time frame [start-time, end-time] and a vehicle, return the trace of that vehicle (GPS entries, ordered by timestamp).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* JDK 8
* [Maven](https://maven.apache.org/)
* [Docker](https://www.docker.com/)

## Build/Usage

	1. Clone project

		$ git clone https://github.com/egilsoncabral/tb_challenge.git
		
	2. Build the project

	    - For build the project, you will need to execute the instructions
        	
         	$ mvn clean package
         	$ docker-compose --compatibility up
        	
        - Now, clone the data loader project, to load the datas on Mongo database:
        	
        	$ git clone https://github.com/egilsoncabral/loadermongo.git
        
        - All instructions to load the data, you can find there.	
        
        - Now access the url:
            > http://192.168.99.100:8080/swagger-ui.html (If you are using docker toolbox)
            > http://localhost:8080/swagger-ui.html (If you are using docker CE)    
    
### Exposed four endpoints:

```
/operators
```

```
/vehicles
```

```
/vehicleAtStop
```

```
/vehicleTrace
```

#### Used Technologies

* Java 8
* Lombok for data models
* SpringBoot 
* Docker
* Swagger
* MongoDB

## Versioning

For versioning, i used the gitHub platform. For more details, (https://github.com/)

## Authors

* **Egilson Cabral** - [TBChallenge](https://github.com/egilsoncabral/tb_challenge)
