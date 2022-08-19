def ordenes(rutinaContable : list):
  from functools import reduce

  ordenMinima = 600000

#Aquí vamos a coger y poner el código de la orden, agregarle la cantidad multiplicada por el precio de cada tupla 
#Quedandonos ejemplo el código de orden1201 y la suma de las tres productos multiplicados por sus respectivas cantidades
  ordenTotal = list(map(lambda x: [x[0]] + list(map(lambda  y: y[1]*y[2], x[1:])), rutinaContable))
#Aquí faltaría sumar esos tres productos por ejemplo y redondearlo a 2 cifras
  ordenTotal = list(map(lambda x: [x[0]] + [reduce(lambda 
  a, b: round(a +b, 2), x[1:])], ordenTotal))
#Por último nos ponen como condición que la orden debe ser mayor a 600000, sino lo es debe pagar 25 mil más y ya
  ordenTotal = list(map(lambda x:x if x[1] >= ordenMinima 
  else (x[0], x[1] + 25000), ordenTotal))

  print('------------------------ Inicio Registro diario ---------------------------------')
#Eso nos quedaría una lista con la orden y el total a pagar, haría falta solo recorrerla e imprimir lo necesario
# con ,.2f aseguramos que antes del punto pondrá coma de miles y que tendrá dos decimales después del punto
#básicamente dandole formato
  for x in range(len(ordenTotal)):
    print(f'La factura {ordenTotal[x][0]} tiene un total en pesos de {ordenTotal[x][1]:,.2f}')

  print('-------------------------- Fin Registro diario ----------------------------------')

	
rutinaContable = [ 
  [1201, ("5464", 4, 25842.99), ("7854",18,23254.99), ("8521", 9, 48951.95)],
  [1202, ("8756", 3, 115362.58),("1112",18,2354.99)],
  [1203, ("2547", 1, 125698.20), ("2635", 2, 135645.20), ("1254", 1, 13645.20),("9965", 5, 1645.20)],
  [1204, ("9635", 7, 11.99), ("7733",11,18.99), ("88112", 5, 390.95)]
]

ordenes(rutinaContable)