'''
1) Desarrolle una función anónima que retorne el promedio de una lista de números
    sum([])
2) Desarrolle una función anónima que reciba como parámetro un String y retorne
    el primer caracter del String
3) Desarrolle una función anónima que reciba como parámetro nombre y apellido, retorne
    en una tupla las iniciales.
        Ejemplo:
            Luis Torres -> (L, T)
4) Desarrolle un software que eleve al cubo todos los números de una lista.
    NOTA: Para este punto debe hacer uso de funciones lambd y funciones
    de orden superior.
'''
#El punto 1
print("\n--SOLUCION PUNTO 1--")

def sumando(lista: list):
    acumulado = 0
    for i in lista:
        acumulado += i
    
    return acumulado

promedio = lambda lista: sumando(lista)/len(lista)

print(promedio([5,5]))

print("--------------------\n")

#El punto 2
print("--SOLUCION PUNTO 2--")

caracter = lambda parametro: parametro[0]

print(caracter("Hola"))


print("--------------------\n")

#El punto 3
print("--SOLUCION PUNTO 3--")

iniciales = lambda nombre, apellido: (nombre[0], apellido[0])

print(iniciales("Juan", "Paez"))

print("--------------------\n")

#El punto 4
print("--SOLUCION PUNTO 4--")


def orden_superior(funcion, lista):
    lista_nueva = []
    for i in lista:
        valor = funcion(i)
        lista_nueva.append(valor)
    return lista_nueva

funcion= lambda i: i*i

print(orden_superior(funcion , [2, 4, 6]))

print("--------------------\n")
