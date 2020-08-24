#Author: amartino@izertis.com
#Keywords Summary : multilanguage
Feature: Generación de RDF en un idioma en concreto a partir de las entidades Proyecto, Universidad, Instituto de investigación, Compañía, Contrato, Grupo de Investigación, Publicación, Tesis, Master Tesis, Artículo, CurriculumVitae

    Scenario: the ETL process a Project object and this object is sent to Management-System
        Given a new message arrives to managementdata queue
        Then the Management-system creates Project RDF object in Spanish language
        Examples:
            | Property          | Value                          |
            | IDPROYECTO        | 151                            |
            | NOMBRE            | CIRUGIA VETERINARIA-RADIOLOGIA |
            | PROYECTOFINALISTA | N                              |
            | LIMITATIVO        | N                              |