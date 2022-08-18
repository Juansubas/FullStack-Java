from functools import reduce


cuadrado = lambda elemento: elemento**2
numeros = [10,20,30,40,50,60,70,80,90]
resultado = set(map(cuadrado, numeros))
print(resultado)

'''
1)Desarrolle una solución que elimine las tildes de una lista de caracteres
    Ejemplo: á -> a
            é -> e
'''



l1 = "Hola sebastián"
print(len(l1))

def comparador(n):
    especiales = ['á', 'é', 'í', 'ó', 'ú']
    normales = ['a', 'e', 'i', 'o', 'u'] 
    resp = ''
    for i in range (0, len(especiales)):
        if n.lower() == especiales[i]:
            if n.isupper():
                resp = normales[i].upper()
            else:
                resp = normales[i]
    if resp == '':
        resp = n
    return resp

resultad = list(map(comparador, l1))
junto = reduce(lambda n,n2: n+n2, resultad)

print(resultad)
print(junto)


