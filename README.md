InventoryAPI
==

InventoryAPI is a basic API for creating inventories easily and quickly with built in item listeners. 

It aims at making inventory creation simpler and more uniform across different plugins.

## Developers
To use the InventoryAPI in your plugin run the following commands:
```
git clone https://github.com/TheMGRF/InventoryAPI.git && cd InventoryAPI
mvn install
```
Then add this into your dependencies section in your projects pom.xml
```xml
<dependency>
    <groupId>me.themgrf</groupId>
    <artifactId>InventoryAPI</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```