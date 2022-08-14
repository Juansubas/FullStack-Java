notas = [
    [
        [4.5, 3.2, 4.9, 4.2],
        [3.5, 4.2, 3.9, 4.8]
    ],
    [
        [4.9, 3.9, 4.9, 3.2],
        [3.8, 4.4, 2.9, 3.8]
    ]
]

prom = []
prom_general = 0
contador_general =0

for x in notas:
    promedio_notas = 0
    contador = 0
    for y in x:
        for z in y:
            promedio_notas +=z
            contador += 1
            contador_general +=1
            prom_general += z
    promedio_notas /= contador
    prom.append(promedio_notas)

print(prom)
print(f"promedio global: {prom_general/contador_general} ")