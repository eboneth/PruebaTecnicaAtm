Feature: Interactual con las 4 opciones de Alert
  @smoke
  Scenario Outline: Como usuario debo ingresar a la opcion Alerts y poder interactuar con las 4 opciones
    Given abrir el navegardor e ingresar al portal y elegir las opciones <menu>, <submenu>
    When interactuar con las opciones de las alertas <texto>
    Then validar el resultado de las alertas

    Examples:
      | menu                    | submenu | texto |
      | Alerts, Frame & Windows | Alerts  |Rafael |

