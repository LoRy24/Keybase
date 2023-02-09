# Keybase
![languages](https://img.shields.io/github/languages/count/LoRy24/Keybase?style=for-the-badge) ![vuln](https://img.shields.io/snyk/vulnerabilities/github/LoRy24/Keybase?style=for-the-badge) ![license](https://img.shields.io/github/license/LoRy24/Hashcraft?style=for-the-badge) ![discussions](https://img.shields.io/github/discussions/LoRy24/Keybase?style=for-the-badge) ![commits](https://img.shields.io/github/commit-activity/y/LoRy24/Keybase?style=for-the-badge)

A simple database API designed to work with custom key-based databases files serialized in JSON objects. 

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
This feature will get available later... Coming very soon!
