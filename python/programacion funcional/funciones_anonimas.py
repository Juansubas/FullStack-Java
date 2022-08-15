def sumar(n1, n2):
    return n1+n2

# lambda crea una función remplazando por ejemplo def sumar()       
# lo que va después de los : es el return

funcion_anonima = lambda : 'Hola mundo desde lambda'

#print(funcion_anonima())

# Agregando parámetros a lambda
sumar = lambda n1 ,n2 : n1 + n2

#print( sumar(5, 5) )

def fabricar_funcion(operador:  str):
    operacion = lambda n1,n2: f'No existe operación para {n1} {operador} {n2}'
#Se aprovechó para reducir lineas
#No se dejó espacio en los condicionales
    if operador == '+': operacion = lambda n1,n2: n1+n2
    elif operador == '-': operacion = lambda n1,n2: n1-n2
    elif operador == '*': operacion = lambda n1,n2: n1*n2
    elif operador == '/': operacion = lambda n1,n2: n1/n2
    elif operador == '**': operacion = lambda n1,n2: n1**n2

    return operacion

operacion = fabricar_funcion('1*')
print( operacion(10, 2) )