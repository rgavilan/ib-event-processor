# Testing BDD

## Configuración del entorno

### Plugins

Se precisa instalar el [plugin cucumber](http://cucumber.github.com/cucumber-eclipse/update-site) para eclipse.

### Dependencias de Maven

Add the `net.masterthought:cucumber-reporting` jar as a dependency in `test` scope

```xml
<dependency>
    <groupId>net.masterthought</groupId>
    <artifactId>cucumber-reporting</artifactId>
    <version>3.8.0</version>
    <scope>test</scope>
</dependency>
```

Una vez instalado el plugin y configuradas las dependencias de maven, para ejecutar las pruebas se necesita ejecutar la instrucción de maven:

```
mvn test
```

## Tests

A continuación se describen los escenarios probados, utilizando el framework [Cucumber](https://cucumber.io/docs/cucumber/)

| Feature                                                            | Descripción                                                                                                                                      |
| ------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------ |
| [`messages.feature`](src/test/java/demo/greeting/greeting.feature) | Pruebas sobre la recepción de mensajes procedentes de la cola kafka _management-data_ y posterior envío al controller del _triple-store-adapter_ |
