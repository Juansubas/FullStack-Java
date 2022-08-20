#Importamos la libreria pandas y le asignamos una abreviación pd
import pandas as pd

#importamos datos del repositorio 
rutaFileCsv = 'https://github.com/luisguillermomolero/MisionTIC2022_2/blob/master/Modulo1_Python_MisionTIC2022_Main/Semana_5/Reto/movies.csv?raw=true'

#definimos la función que recibirá dichos datos
def listaPeliculas(rutaFileCsv: str) -> str:
    #usamos [-1] pues despues de() tendriamos la lista y en último elemento la extensión, dejando así solo la extensión
    #en el if para comparar que sea igual a 'csv?raw=true'
    if rutaFileCsv.split('.')[-1] == 'csv?raw=true':
        try:
            csv = pd.read_csv(rutaFileCsv)
            subGrupoPeliculas = csv[['Country', 'Language', 'Gross Earnings']] #Crea estos indices
            gananciaPaisLenguaje = subGrupoPeliculas.pivot_table(index=['Country', 'Language']) #hacemos referencia a dos indices
            return gananciaPaisLenguaje.head(10) #imprime primeras 10 medias de estos datos
    
        except:
            print('Error al leer el archivo de datos.')
    
    else:
        print('Extensión inválida.')
    return

print(listaPeliculas(rutaFileCsv))
