Feature: Registrar datos personales y visualizar en la tabla
  @smoke
  Scenario Outline: Como usuario registrado debo poder registrar los datos de algun usuario y verlos reflejados en la tabla.

    Given Navegue por el menu pagina y elegir la opcion <menu> -> <submenu>
    When ingrese debo agregar un nuevo usuario con los datos <nombre>, <apellido>, <email>, <edad>, <salario>, <departamento>
    Then validar que se visualice en la tabla el usuario <nombre>
    And cerrar el navegador

    Examples:
      | menu     | submenu    | nombre | apellido | email         | edad | salario | departamento |
      | Elements | Web Tables | Rafael | Bonett   | mail@mail.com | 34   | 150000  | Sistemas     |