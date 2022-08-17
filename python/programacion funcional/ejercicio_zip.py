from functools import reduce


'''

A -> #
B -> @
C -> !
D -> "

'''

letras = ['A','B','C','D','E','F','G','H','I','J']
caracteres_especiales = ['#','@','!','"','-','_','%','?','¿','=']

relacion_letras_caracteres = list( zip(letras, caracteres_especiales))

def codificar_mensaje(relacion_letras_caracteres: list, mensajes: str):
#La función que se le pasa a filter debe retornar un booleano para el filtrar la lista
#filtrar y filtrar_dos se pueden hacer juntas, pero para ser mas legibles es mejor por partes
#en el filtrar creamos una funcion anónima la cual realizará un filtro teniendo de condición evaluar
#el primer caracter del mensaje que le pasamos y debe hacer coincidencia si esta en nuestra relación_letras
#ademas que mediante upper si el mensaje fuera hola, lo eleva a la mayuscula pero extrae de las letras que creamos
#como estandar para comparar, luego debemos hacer que esta función se aplique a el mensaje en un for, mediante map
#que sería filtrar_dos
#como queda la clave y la letra, lo separamos recorriendo otra vez todo y seleccionando lo deseado
#luego vamos a eliminar el array resultante y juntar el código codificado 


    filtrar = lambda letra: list(filter(lambda tupla : tupla[0]==letra.upper(), relacion_letras_caracteres))
    filtrar_dos = list(map(filtrar, mensajes))
    codificacion = list(map(lambda a: a[0][1] ,filtrar_dos))
    codificacion = reduce( lambda ac, e: ac+e, codificacion)
    return codificacion


#Aquí llamamos la función y le pasamos parámetros
print(codificar_mensaje(relacion_letras_caracteres, "bebe"))