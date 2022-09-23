//Iniciamos el servidor con spring boot
//Dejamos la dirección con la ruta .
const URL_API = "http://localhost:8080/mascotas"

//con async indicamos que la función será asincrona 
// con await indicamos que parte del código debera ser escuchado hasta que de respuesta

async function get_mascotas () {
  // Enviar Petición
  const resp = await fetch(URL_API)
  // Obtener datos de la petición
  // Esto es para datos json, significa 
  // Que retorna un objeto y lo organizamos en json
  const mascotas = await resp.json()
  return mascotas
}

//Ahora falta mostrar las mascotas

function show(mascotas) {
  const tbody = document.getElementById("tbody")
  // Crearemos el string para concatenar codigo
  let tr_body = ""
  //Iterar mascotas
  for(let i = 0; i < mascotas.length; i++){
    const obj = mascotas[i] //Para evitar que el código quede muy extenso
    // COn &nbsp dejamos un espacio
    // Con onclick se dispara al hacer click , ahí haremos llamado a una funcion update
    // Html no reconoce objetos por eso debemos convertir el obj en un objeto con
    //JSON.stringify(obj)
    tr_body += `
    <tr>
      <td>${obj.id}</td>
      <td>${obj.nombre}</td>
      <td>${obj.apellido}</td>
      <td>${obj.tipo_mascota}</td>
      <td>${obj.raza}</td>
      <td>${obj.edad}</td>
      <td>${obj.observacion}</td>
      <td>
        <button class="btn btn-warning" onclick='update(${JSON.stringify(obj)})'>Actualizar</button>
        &nbsp;
        <button class="btn btn-danger">Eliminar</button>
      </td>
    </tr>
    `
  }

  //Insertaremos en donde tenga id tbody el tr_body
  tbody.innerHTML = tr_body
}

function update (mascota) {
  //con window hacemos referencia a la pantalla del navegador
  // con location tenemos idferentes formas
  //con href referenciamos
  //podemos enviar por ejemrplo form.html?nombre=andres&apellido=quintero
  //pero como es algo maluco de largo y manual
  //mejor pasamos todo el objeto
  window.location.href = `form.html?mascota=${JSON.stringify(mascota)}`
}

async function main() {
  //guardamos las mascotas
  const mascotas = await get_mascotas()
  show(mascotas)
}

main()