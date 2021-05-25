# Dictionary Console Application

Dictionary Console Application, a console application to store Multi-Value attributes i.e., mapping each key to a collection of values

# Documentation
List of available operations that can be performed in the console

```
KEYS, MEMBERS, ADD, REMOVE, REMOVEALL, CLEAR, KEYEXISTS, VALUEEXISTS, ALLMEMBERS, ITEMS, EXIT, HELP
```
To get operation description for individual operation use HELP

```
HELP <operation>
example: HELP KEYS
```
Please verify this word document for detail description of each operation and their usage

#Application Requirements

Java Version : Java 8 and above

Gradle version: 4.8.1 and above

# Building in your local
Go to project root directory and run below in your command line

```
.\gradlew clean build
```

![GradleCleanBuild](./documentation/images/GradleCleanBuild.JPG)

#Running Dictionary Console Application

####Running the delivered executable jar
Add executable jar for convenience. You can run the dictionary.jar available in application folder in project root directory.

Before running the jar make sure java home is set in your environment. Please verify helpful links at the bottom for more information about setting JAVA_HOME.

```
java -jar dictionary.jar
```
![DictionaryExecutableJar](./documentation/images/DictionaryExecutableJar.JPG)


####Building and running executable jar
After running .\gradlew clean build you can see the dictionary executable jar in <project root directory>/build/libs/dictionary.jar

![ExecutingDictionaryJar](./documentation/images/ExecutingDictionaryJar.JPG)

Above commands ran in windows environment for mac/linux you should be able to run similar commands


#Helpful Link

[Set JAVA_HOME for windows](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)

[Set JAVA_HOME for macOS](https://mkyong.com/java/how-to-set-java_home-environment-variable-on-mac-os-x/)

[Java SE Development Kit 8 Downloads](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
