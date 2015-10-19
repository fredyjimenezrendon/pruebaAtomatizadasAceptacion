Feature: Busqueda de libros

  Como: estudiante de ingenieria
  Deseo: un formulario de busqueda de libros
  Para: Buscar libros que me ayuden con los trabajos
 
  Scenario: Buscar libros por anio de publicacion
    Given El usuario busca libros publicados entre 2013 y 2015
    When El usuario presiona el boton buscar
    Then Aparecen 2 libros en la lista de resultados
      And El libro 1 debe tener el titulo 'Algebra lineal'
      And El libro 2 debe tener el titulo 'Calculo II'