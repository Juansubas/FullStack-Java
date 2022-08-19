import pandas as pd

guion = lambda : print('--------------------------------------------------------------')

#Esto es como un excel nos da un identificador a pesar de no poner etiquetas
#para establecer nuestas etiquedas lo hacemos con index

#Si el valor que tiene la serie es '20' o una fecha '2022/05" lo identifica como objeto
#pero funciona, pero eso nos permite manipular la serie de diferente maneras al ser un obj

miSerie = pd.Series( [10, 20, 30 ,40] , index= ['ene', 'feb', 'mar', 'abr'])

#Imrpimiendo valores de la serie

print( miSerie[2] )
print(miSerie['mar'])

#Accediendo al objeto que contiene el indice
print(miSerie.index)
#Los indices no se pueden cambiar si los pusimos directamente en el objeto
#por lo tanto es bueno poner la variable y declararlo por fuera para así poder acceder y hacer cambios 
#ejemplo

miSerie.index = ['Enero','Febrero','Marzo', 'Abril']
print(miSerie)

guion()

#OBTENER ELTIPO DE DATO DE LA SERIE

print(miSerie.dtype)

#Aquí podemos indicar el nombre de la serie
#y el nombre de las etiquetas
miSerie.name = 'Ventas 2022'
miSerie.index.name = 'Meses'
print(miSerie)

guion()
#Atributo para a los identificadores de filas y columnas en el caso del dataframe
print(miSerie.axes)

#Acceder a la dimensiones de la serie/Dataframe
print(miSerie.shape)

guion()
#CREAR UN DATAFRAME
#MEJOR MANERA DE CREAR UN DATAFRAME ES USAR UN DICT
#LAS CLASES SERAN LOS IDENTIFICADORES Y LOS VALORES LAS SERIES

dict_ventas = {
    'frutas' : [150, 80, 200, 10, 250],
    'aseo' : [300, 90, 120, 140, 450]
}

#ahora convertirmos el dict a un dataframe mediante pandas
#recuerde que el dataframe son dos dimensiones, es como una hoja de excel o de calculo 
meses = ['Enero','Febrero','Marzo', 'Abril', 'Mayo']
data_ventas = pd.DataFrame( dict_ventas,  meses )
#Este queda implicito como el nombre de las columnas
data_ventas.name = 'Ventas 2021'
#Este se verá al imprimir el dataframe, nombre filas
data_ventas.index.name = 'Meses'

print(data_ventas)
#Como son dos dimensiones tendra indices de las filas y de las columnas 
guion()
print( data_ventas.index )
print( data_ventas.columns )

#Acceder a las dimensiones 
guion()
print ( data_ventas.axes )
print( data_ventas.shape)

guion()
#ACCEDER A LOS VALORES

print( data_ventas.values )
guion()
#Para acceder primero la columna y después la fila
print( data_ventas['frutas']['Enero'])

#Operaciones 
guion()
#El total ventas como un diccionario
data_ventas['total_ventas'] = data_ventas.frutas + data_ventas.aseo
print(data_ventas)

guion()
#Accediendo a la información global del datafrmae
print (data_ventas.info())
guion()
# Otra información estadística sobre los datos
print (data_ventas.describe())
guion()

#ACCEDER A LOS PRIMEROS 5 REGISTROS
print( data_ventas.head() )
print( data_ventas.head(2) ) #Accediendo a una cantidad n primeros
guion()
#ACCEDER A LOS ÚLTIMOS 5 REGISTROS
print( data_ventas.tail())
print( data_ventas.tail(1))
