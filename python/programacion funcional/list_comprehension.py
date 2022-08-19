numeros = [10,20,30,40,50,60,70,80,90]

#Aquí antes del for ponemos la instrucción.
numeros_al_cuadrado = [n**2 for n in numeros]

print(numeros_al_cuadrado)

formula = lambda n: (n+10)*2

lista = [ formula(n) for n in numeros]

print(lista)

'''
Forma tradicional de elevar números al cuadrado en una lista

lista = []

for n in numeros:
    lista.append( n**2 )

'''

nombres = ['Andrés', 'Juliana', 'Claudia', 'Oliver', 'Bladimir']

'''
A partir de la lista de nombres genere una lista de tuplas, convirtiendo
cada nombre a una tupla
'''
convertir_tupla = [tuple(n) for n in nombres]

print(convertir_tupla)

numeross = [10,20,30,40,50,60,70,80,90,15,25,35,45,55,65,75,85,95]

numeros_pares = [n for n in numeross if n%2==0]
print(numeros_pares)
numeros_impares = [n for n in numeross if n%2==1]
print(numeros_impares)

'''
* Generar una lista con los nombres que empiezan por j y guardarlos en minúscula, de
    lo contrario guardarlos en mayúscula

'''
nombresss = ['Andrés', 'Juliana', 'Claudia', 'Oliver', 'Bladimir', 'Juan', 'Jorge', 'Julieta']

#Cuando se usa if y else como ternario, se debe poner antes del for, de lo contrario después

nuevo_nombresss = [n if n[0]=='J' else n.upper() for n in nombresss]

print(nuevo_nombresss)