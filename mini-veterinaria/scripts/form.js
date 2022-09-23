//Recomendacion documento a parte con todas las URL
const URL_API = "http://localhost:8080/mascotas"

function get_data_form (evt) {
    // Indicar por medio del evento que no recargue página
    evt.preventDefault()
    //Con evt.target.nombre accedemos al elemento y a partir de ahí podemos acceder a su valor u otras cosas
    // para el valor es evt.target.nombre.value
    // evt.target es el formulario 
    // para evitar escribir tanto guardaremos ese codigo en una vartiable
    /* 
    const form = evt.target
    const nombre = form.nombre.value
    const apellido = form.apellido.value
    const raza = form.raza.value
    console.table({
        nombre, apellido, raza
    })

    console.log(document.getElementById(nombre_mascota))
    */
    //Vamos a hacerlo con un objeto para ser mejor
    const form = evt.target
    //los nombres de ese objeto deben ser igual a los del modelo de java
    // de esta forma nos ahorramos dolores de cabeza al enviarle esa info al server
    const mascota = {
        nombre: form.nombre.value,
        apellido: form.apellido.value,
        tipo_mascota: form.tipo_mascota.value,
        raza: form.raza.value,
        edad: form.edad.value,
        observacion: form.observacion.value
    }

    //Podemos llamar el nombre de las mascota por ejemplo con document.getElementById("nombre_mascota")
    
    //Nos vamos a tener ya este console.table 
    //console.table(mascota)
    create(mascota)
    clear(form)

}

async function create(mascota){
    // Enviar peticion
    const resp= await fetch(URL_API, {
        //por defecto el metodo es get por eso debemos indicarlo
        method: 'POST',
        //Vamos a indicar que enviará un objeto JSON
        headers: {
            'Content-Type': 'application/json'
        },
        //En el cuerpo enviaremos la mascota
        //convertimos el objeto mascota a JSON string
        body: JSON.stringify(mascota)
    })

    //Vamos a capturar lo que retorna el create del servidor
    //EN el servidor pusimos que cuando cree la mascota nos envia un texto
    //diciendo que mascota creada con éxito

    const text = await resp.text()
    //usamos un alert
    alert(text)
}

function clear (form) {
    //con setAttribute primero pondremos el atributo y el segundo la acción o sea en este caso dejarlo vacio
    //document.getElementById("nombre_mascota").setAttribute("value", "")

    form.nombre.value = ""
    form.apellido.value = ""
    form.tipo_mascota.value = ""
    form.raza.value = ""
    form.edad.value = ""
    form.observacion.value = ""

}
//Vamos a poenr los valores del form en las casillas para actualizar

function set (form, mascota) {
    form.nombre.value = mascota.nombre
    form.apellido.value = mascota.apellido
    form.tipo_mascota.value = mascota.tipo_mascota
    form.raza.value = mascota.raza
    form.edad.value = mascota.edad
    form.observacion.value = mascota.observacion

}

//Aquí obtendremos los valores 
function get_params () {
    //Obtendremos lo parámetros de la URL
    //Aquí obtendremos lo qu esta después del ?
    const search = window.location.search
    //Acá lo transformamos a un string
    const url = new URLSearchParams(search)
    // ahora podremos manejarlo obteniendo a mascota
    const param_mascota = url.get("mascota")
    if(param_mascota) {
        //ahora lo convertimos a un objeto
        const mascota = JSON.parse(param_mascota)
        const form = document.getElementById("form")
        set(form, mascota)
    }


}

get_params()

