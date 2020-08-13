# Testing BDD con Cucumber

## Configuración del entorno

### Plugins

Se precisa instalar el [plugin cucumber](http://cucumber.github.com/cucumber-eclipse/update-site) para eclipse.

<img src="img/pluginCucumber.png" height="350px" style="display:block; margin-left: auto; margin-right:auto; width:90%;"/>

### Dependencias de Maven

Se añaden las dependencias de cucumber en el _pom.xml_ version `6.4.0` con el scope `test`.

```xml
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-spring</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.masterthought</groupId>
            <artifactId>cucumber-reporting</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
```

Una vez instalado el plugin y configuradas las dependencias de maven, para ejecutar las pruebas se necesita ejecutar la instrucción de maven:

```
mvn test
```

## Como crear un test BDD

### Estructura de carpetas

```
proyecto
  src
    test
      features
        (ficheros del tipo *.feature)
      java
        es
          um
            asio
              runners
                (ficheros del tipo *Runner.java)
                stepdefs
                  (ficheros del tipo *StepDefinitions.java)
```

Ejemplo:
<img src="img/estructura-carpetas.png" style="display:block; margin-left: auto; margin-right:auto; width:50%;"/>

## Escenarios

A continuación se describen los escenarios probados, utilizando el framework [Cucumber](https://cucumber.io/docs/cucumber/)

| Feature                                                            | Descripción                                                                                                                                          |
| ------------------------------------------------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| [`messages.feature`](src/test/java/demo/greeting/greeting.feature) | Pruebas sobre la recepción de mensajes procedentes de la cola kafka **management-data** y posterior envío al controller del **triple-store-adapter** |
