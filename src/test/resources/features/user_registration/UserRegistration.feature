# language: es
@UserRegistration @HighCohesion
Característica: Registro de Nuevos Usuarios en la Plataforma
  Como usuario de la tienda en línea
  Quiero registrar un nuevo perfil
  Para realizar transacciones de forma segura

  Esquema del Escenario: Registro de usuario exitoso utilizando estructuras tabulares dinámicas
    Dado que el usuario abre la página de inicio de la tienda
    Cuando interactúa con el formulario ingresando los datos correspondientes
      | nombre   | apellido   | direccion   |
      | <nombre> | <apellido> | <direccion> |
    Entonces el sistema debería validar la creación exitosa del perfil en la plataforma

    Ejemplos:
      | nombre | apellido | direccion |
      | juan   | correa   | calle     |
      | pedro  | ortiz    | carr      |
