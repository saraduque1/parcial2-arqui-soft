# PARCIAL PRACTICO ARQUITECTURA DE SOFTWARE    
*GRUPO 2-6*

### MIEMBROS
- BALLESTERO ORTIZ VALERIA  
- CASTILLO MORALES GERARDO ESTEBAN  
- CIFUENTES ESCOBAR ALEJANDRO  
- DUQUE RAMIREZ SARA LORENA  
- GIRALDO LOAIZA JOHN HAIDER  
- TAMAYO ESPINOSA CRISTIAN DAVID  

## Cómo usar

Para utilizar esta aplicación primero debes usar el comando de:
~~~powershell
docker compose up
~~~
dentro de la carpeta raíz del proyecto y así montarla dentro de contenedores docker
con su base de datos y unos ejemplos dentro de ella por defecto

Los endpoint son:
- **Get:**    
    `/v1/notas/estudiante/{cedula}`: aquí podras obtener todas las notas de un estudiante a partir de su cédula.
- **Post:**
    `/v1/notas/estudiante/{cedula}`: Usando este mismo endpoint puedes agregar notas de una materia para un estudiante en particular.   
    Para agregar estas notas lo puede hacer usando la siguiente estructura de objeto:
    ~~~JSON
        {
            "codigoMateria": "MAT101",
            "notas": [32,34,76,34,12]
        }
    ~~~