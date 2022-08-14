entrada= ([
    (2001,'rosca', 'PT29872',2,45,'Luis Molero',3456,'12/06/2020'),
    (2010,'bujía', 'MS9512',4,15,'Carlos Rondon',1256,'12/06/2020'),
    (2010,'bujía', 'ER6523',9,36,'Pedro Montes',1243,'12/06/2020'),
    (3578,'tijera', 'QW8523',1,128,'Pedro Faria',1456,'12/06/2020'),
    (9251,'piñón', 'EN5698',2,8,'Juan Peña',565,'12/06/2020')])


def AutoPartes(ventas: list):
    return dict(zip(range(len(ventas)), ventas))
    
def consultaRegistro(ventas, idproducto):
    bandera = False
    for item in ventas.values():
        if item[0] == idproducto:
            print(f"Producto consultado : {item[0]}  Descripción  {item[1]}  #Parte  {item[2]}  Cantidad vendida  {item[3]}  Stock  {item[4]}  Comprador {item[5]}  Documento  {item[6]}  Fecha Venta  {item[7]}")
            bandera = True
    if bandera == False:
        print("No hay registro de venta de ese producto")

print(AutoPartes(entrada))