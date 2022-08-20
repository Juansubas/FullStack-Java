import json

def guardar_info(info, ruta_fichero):
    with open(ruta_fichero, 'w') as archivo:
        json.dump(info, archivo) #crea archivos y no carpetas

vehiculos = {
    "vehiculo_1": "ART223", 
    "vehiculo_2": "RJQ554"
}

ruta_actual = "python/manejo_ficheros/ficheros/"


guardar_info(vehiculos, ruta_actual + 'vehiculos.json')

persona = {
    'nombre': input('Nombre: '),
    'apellido': input('Apellido: '),
    'edad': int(input('Edad: '))
}
guardar_info(persona, ruta_actual + 'persona.json')
