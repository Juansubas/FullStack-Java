#Programación Funcional

def sumar(n1, n2):
    return n1+n2

referencia = sumar

print( referencia(20,20) )

otra_referencia = referencia    

print( otra_referencia(20,20) )