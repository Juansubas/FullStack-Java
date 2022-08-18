
numeros = [10, 15, 20, 25, 30, 35, 40, 45, 50, 55]

pares = list(filter(lambda n: n%2 != 1, numeros))
impares = list(filter(lambda n: n%2 == 1, numeros))

print(pares, impares)


'''
1) A partir de la lista 'nombres' filtrar todos los nombres que comiencen por J

'''

nombre = ['Andres', 'Juan', 'Juliana', 'Jorge', 'Iván', 'Hugo', 'Oliver', 'Jairo']

j = list(filter(lambda n: n[0]=='J',nombre))

print(j)
