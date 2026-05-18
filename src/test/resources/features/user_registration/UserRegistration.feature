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
      | nombre           | apellido        | direccion          |
      | José Alfredo     | Martínez Valdés | Carrera 43 # 46-40 |
      | Nathalia Andrea  | Martínez Ijají  | Carrera 23 # 31-06 |
      | Valeria          | Méndez Escobar  | Calle 30 # 24-18    |
      | Juan Sebastián   | Martínez Ijají  | Carrera 28 # 35-12 |
