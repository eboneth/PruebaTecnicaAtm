Feature: Ingresar valores al datepicker
  @smoke
  Scenario Outline: como usuario debo poder ingresar una fecha al campo select date y al campo date and time respectivamente

    Given ingresar a la pagina y navegar a la opcion <menu>, <submenu>
    When cuando ingrese debo agregar fechas validas a los campos <selectDay>
    Then debo poder cerrar el navegador

    Examples:
      | menu    | submenu     | selectDay  |
      | Widgets | Date Picker | 09/29/2022 |