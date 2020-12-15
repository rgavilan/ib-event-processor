![](../images/logos_feder.png)

# Testing BDD con Cucumber

## Configuración del entorno

Ver documento [README](https://github.com/HerculesCRUE/ib-asio-docs-/blob/master/entregables_hito_2/testing/testing.md) para la configuración de los tests.

## Escenarios

A continuación se describen los escenarios probados, utilizando el framework [Cucumber](https://cucumber.io/docs/cucumber/)

| Requisitos                                                | Feature                                                     | Descripción                                                                                                                                          |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
RF3.14<br>RF3.18<br>RF3.2<br>RF3.4	| [`messages.feature`](../src/test/features/messages.feature) | Pruebas sobre la recepción de mensajes procedentes de la cola kafka **management-data** y posterior envío al controller del **triple-store-adapter** |



## Reporte

* [Cucumber Report](http://herc-iz-front-desa.atica.um.es:8070/event-processor/cucumber/overview-features.html)



## Anexo



[Enlace a la documentación sobre requisitos funcionales](https://github.com/HerculesCRUE/ib-asio-docs-/blob/master/entregables_hito_1/12-An%C3%A1lisis/Requisitos/Documents/Requisitos%20funcionales.md)