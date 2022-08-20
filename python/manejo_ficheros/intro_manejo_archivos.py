import json #Importando json

#Creamos un diccionario vacio para almacenar los datos de json
#pues si no hacemos esto la refencia no puede salir del with y no podríamos manipularlo por fuera
persona = {}

def abrir_archivo(ruta: str):
#Referenciando el archivo json
    cadena = ruta.split('.')
    if cadena[1].lower() == "json" :#validar extensión del archivo
        try: 
            
            with open(ruta) as archivo:
                #cargar datos del archivo json
                persona = json.load(archivo)
                print(persona)

            #referenciando el fichero
            #aquí vamos a crear un archivo , pero independiente
            #de si existe o no debemos darle permisos de escritura si vamos 
            #a ahcer cambios en uno existente o el que creamos
            #esto lo hacemos con , 'w'
                """    
            with open('python/manejo_ficheros/personas.json', 'w') as archivo:
                #Escribir/crear el fichero
                json.dump(persona, archivo) #lo que quiero escribi y donde lo voy a escribir
                #como no existe el lo va a """
                
        except:
            print('Error al cargar los datos')
        #print(persona[1]['nombre'])
    else:
        print(f"Extensión inválida, pues es .{cadena[1].lower()} y debería ser .json")

abrir_archivo('python/manejo_ficheros/persona.json')
#El archivo .json identificamos las cosas como objetos
#al pasar la misma estructura a python lo identifica como diccionario