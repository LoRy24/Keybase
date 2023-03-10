# Keybase
![languages](https://img.shields.io/github/languages/count/LoRy24/Keybase?style=for-the-badge) ![vuln](https://img.shields.io/snyk/vulnerabilities/github/LoRy24/Keybase?style=for-the-badge) ![license](https://img.shields.io/github/license/LoRy24/Hashcraft?style=for-the-badge) ![discussions](https://img.shields.io/github/discussions/LoRy24/Keybase?style=for-the-badge) ![commits](https://img.shields.io/github/commit-activity/y/LoRy24/Keybase?style=for-the-badge)

A simple database API designed to work with custom key-based databases files serialized in JSON objects. 

> ⚠️ The wiki for this project is currently under development. Stay tuned!

## More details:
This framework is very useful when you want to work with simple databases designed on a key<->value system. In fact, this tool will help you managing a database
serialized in a JSON string that contains a map containing keys and objects.

This can be very useful when you want to serialize entire objects without having to worry about tables such as MySQL ones. If you want an example of how this
is designed, look at the Redis system. 

## Databases Structure:
As said before, the databases are serialized as a JSON object. This object is just the DatabaseObject class serialized using Google GSON api. If the format
is not supported, the database won't be red. 

The format of the file can be whatever you want, but you should use the **.kybdb** one, for a more clean way to detect which file is it.

## Connect Maven:
If you want to use this framwork with Maven, you just have to add the following dependency:
```xml
<dependencies>
  <dependency>
    <groupId>com.github.lory24</groupId>
    <artifactId>keybase</artifactId>
    <version>1.0.0_2-RELEASE</version>
  </dependency> 
</dependencies>
```
> Remember to replace the version with the latest one.
