import numpy as np

guion = lambda : print('-----------------------------------------')

#Crear una matriz
#debe dentro de .array() poner [] el cual será el padre de la matriz como decir donde se va a trabajar
#Cada braket interno es una fila y sus elementos las columnas

matriz = np.array( [[1, 2], [2, 1]] )

guion()
print(matriz)
guion()

#[4,3] le estamos indicando que tendrá 4 filas y 3 columnas
#con .zeros nos aseguramos de crear una matriz de ceros
matriz_zeros = np.zeros([4,3])
print(matriz_zeros)

guion()

#lo mismo pero con unos
matriz_ones = np.ones([4,3])
print(matriz_ones)

nombres = ['Juan', 'María', 'Juliana', 'Sebastian']

guion()

#para ahorrarnos np.random.choice, podriamos poner
#from numpy import random as r , esto hace que np.random se llame r
# pero ojo solo importamos esa función el resto no
# con replace podemos decir si permitimos que se pueda repetir un valor
#con p=[] podemos asignar probabilidades que queramos a cada elemento
ganadores = np.random.choice(nombres, size = [2], p=[0.1, 0.2, 0.5, 0.2], replace=False)

#para poner el tamaño aleatorio hacemos lo siguiente:
# size = np.random.choice([1,2], size=[1])
# de esta manera vamos a generar un valor entre 1 y 2 aleatorio.
print(ganadores)

#Multiplica el array 1 con el array 2 
numeros_1 = np.array([ [10,20,30,40], [50,60,70,80] ]) 
numeros_2 = np.array([ [12,15,20,90], [70,60,50,40] ]) 

#Sumar
#Se puede usar .add o solo la suma con el +
suma = np.add( numeros_1, numeros_2 )
suma = numeros_1 + numeros_2
print(suma)

#Restas
guion()
resta = np.subtract( numeros_1, numeros_2 )
resta = numeros_1 - numeros_2
print(resta)

#Multiplicación elemento a elemento
multiplicacion = numeros_1 * numeros_2
print(multiplicacion)

#Dividir
dividir = numeros_1 / numeros_2
print(dividir)

print('\n ')
guion()

matriz_1 = np.array( [ [2,5,4], [1, 2, 10] ] )
matriz_2 = np.array( [ [10,2], [8,4], [1,5] ] )

guion()
#Multiplicación de matrices
mult = np.dot(matriz_1, matriz_2)
print(mult)

nombres = ['Juan', 'María', 'Juliana', 'Sebastián']
#Reordenar la lista
np.random.shuffle( nombres )
print(nombres)

