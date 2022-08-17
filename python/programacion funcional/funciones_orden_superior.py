#Son funciones que reciben como parámetros otras funciones
#Mediante referencias a funciones, queda mejor para organizarlo.
#Se realiza una función la cual retornará otra función, con esto 
#tenemos luego una función de orden superior la cual tomará esa función y la procesará de acuerdo
#a los parámetros dados.

def fabricar_operacion(operador):
    respuesta = ''

    if operador == '+':
        def sumar(n1, n2):
            return n1+n2
        respuesta = sumar

    elif operador == '-':
        def restar(n1, n2):
            return n1-n2
        respuesta = restar

    return respuesta

def funcion_orden_superior(funcion):
    resultado = funcion(10, 20) #llamado de función pues le da valores
    print('El resultado es  =>', resultado)

operacion = fabricar_operacion('+') #Asignación
funcion_orden_superior(operacion)