Feature: Eliminar usuario en la tabla
  @smoke
  Scenario Outline: Como usuario debo poder eliminar los datos de algun usuario en la tabla.

    Given Navegar por el menu pagina y elegir la opcion <menu> -> <submenu>
    When ingrese debo eliminar el usuario <nombre>
    Then validar que se haya eliminado correctamente de la tabla <nombre>
    And cierra el navegador

    Examples:
      | menu     | submenu    | nombre   |
      | Elements | Web Tables | Cantrell |