import pandas as pd
import numpy as np

movies = pd.read_csv('python/pandas/movies.csv')

#Creando un subData Frame y posterior la tabla Pivote (tabla dinámica)
#print(movies.info())

subDataFrame = movies.loc[:, ['Director', 'Gross Earnings', 'Facebook likes - Movie', 'User Votes']]
#Función por defecto es la media de los datos
#para nuevas funciones usamos aggfunc y también podemos modificar la que tiene por defecto
#Hay que importar Numpy
tabla_dinamica = pd.pivot_table(subDataFrame, index = ['Director'], aggfunc=[np.size])
print(tabla_dinamica.head(10))

#print(subDataFrame)