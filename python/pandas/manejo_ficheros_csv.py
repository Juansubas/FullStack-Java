from re import sub
import pandas as pd

guion = lambda: print('--------------------------------------------------')

#Si vamos a usarlo de forma externa debemos hacer lo sgte
#rutaFileCsv = 'https://github.com/luisguillermomolero/MisionTIC2022_2/blob/master/Modulo1_Python_MisionTIC2022_Main/Semana_5/Reto/movies.csv?raw=true'
#movies = pd.read_csv('rutaFileCsv')

#Para hacerlo de forma local debemos poner la ruta del archivo
movies = pd.read_csv('python/pandas/movies.csv')

print( movies.info() )
guion()

print(movies.describe())

title = movies['Title']
#Nos imprime los titulos
#Podemos con tail o con head que nos imprima los primero n o últimos
print(title)
guion()
#10 titulos de película de forma aleatoria
print( title.sample(10))

#Crear subDataframe loc recibe dos parametros
# primer parámetro de que fila hasta que fila
# Segundo parámetro rango de columnas
subDataframe = movies.loc[0:100, ['Title', 'Genres', 'Duration', 'Facebook Likes - Director', 'Facebook likes - Movie']]
#print(subDataframe)
#vamos a filtrar las peliculas menores a 100 minutos
pelis_menor_100 = subDataframe[ subDataframe['Duration'] < 100]
print(pelis_menor_100) 

#Crear nueva columna que sume otras dos
subDataframe['Total likes'] = subDataframe['Facebook Likes - Director'] + subDataframe['Facebook likes - Movie']
print(subDataframe.describe())

#Vamos a buscar las peliculas mas vistas de acuerdo a un parámetro
pelis_popupales = subDataframe[ subDataframe['Total likes'] > 30000]

print(pelis_popupales)