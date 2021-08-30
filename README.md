# CreditCardValidatorAPI 💳

RESTful API built in Java that checks if a credit card is valid using the Luhn algorithm 🖥️

[![Made with JDK 15](https://forthebadge.com/images/badges/made-with-java.svg)](https://jdk.java.net/15)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See below for prerequisite libraries and notes on how to deploy the project on a live system.

`git clone https://github.com/mahirahman/CreditCardValidatorAPI.git`

1. Open the project in Eclipse IDE (Or any other IDE)
2. Go to Maven --> Update Project
3. Run the project locally using Apache Tomcat
4. Project deployed locally on `localhost:8080/CreditCardValidatorAPI/v1/`

## Parameters

```
cardNum: Integer Number of Credit Card
```

## Endpoints

```
GET  /validates?card_num={cardNum}
```

## Prerequisites

```
JDK 15
Apache Tomcat 9
```

## Built With

* [JDK 15](https://jdk.java.net/15) - Programming Language
* [Eclipse Java EE](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers) - Java IDE
* [Maven](https://maven.apache.org/what-is-maven.html) - Package Manager
* [Apache Tomcat 9.0.41](https://downloads.apache.org/tomcat/tomcat-9/v9.0.41/README.html) - Web Server Enviroment
* [Jersey 2.33](https://github.com/eclipse-ee4j/jersey/releases/tag/2.33) - Jersey

## Versioning

Using [SemVer](http://semver.org/) for versioning.

## License

* [General Public License v2.0](https://github.com/mahirahman/CreditCardValidatorAPI/blob/master/LICENSE)

## Authors

* **Mahi Rahman**