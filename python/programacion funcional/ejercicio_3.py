'''
1) Desarrolle una función que recibe como parámetro una lista de String y
    retorne una lista de String donde cada elemento tenga la inicial en mayúscula
'''

nombre = ['andres', 'julián', 'iván', 'maría', 'mónica']

#Forma sin usar replace
nuevo = list(map(lambda n: (n[0][0].upper() + n[1:]), nombre ))

#Usando replace
nuevo_dos = list(map(lambda n: n.replace(n[0], n[0].upper()), nombre))

print(nuevo_dos)