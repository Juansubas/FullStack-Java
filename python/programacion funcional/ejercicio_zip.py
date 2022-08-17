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
    filtrar = lambda letra: list(filter())

print(relacion_letras_caracteres)