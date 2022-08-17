#Programación Funcional
#Guardas la referencia a la función en una variable, comportandose la variable como función
#cuando se quiera guardar es sin parentésis pues estos llaman la función, por lo tanto
#al guardar sin parentesis, se referencia 

def sumar(n1, n2):
    return n1+n2

referencia = sumar

print( referencia(20,20) )

otra_referencia = referencia    

print( otra_referencia(20,20))