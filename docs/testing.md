![](../images/logos_feder.png)

# Testing BDD con Cucumber

## Configuración del entorno

Ver documento [README](https://github.com/HerculesCRUE/ib-asio-docs-/blob/master/common/testing/testing.md) para la configuración de los tests.

## Escenarios

A continuación se describen los escenarios probados, utilizando el framework [Cucumber](https://cucumber.io/docs/cucumber/)

| Feature                                                     | Descripción                                                                                                                                          |
| ----------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| [`messages.feature`](../src/test/features/messages.feature) | Pruebas sobre la recepción de mensajes procedentes de la cola kafka **management-data** y posterior envío al controller del **triple-store-adapter** |
