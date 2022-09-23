package com.hibernate.introduction.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.introduction.modelo.Mascota;
import com.hibernate.introduction.servicios.MascotaServicio;

//Decorador que indica que procesará peticiones http
@RestController
//Aquí creamos una ruta
//La cual activará esta clase
@RequestMapping("/mascotas")
public class MascotaControlador {

  private MascotaServicio servicio;

  //Aquí 
  public MascotaControlador() {
    this.servicio = new MascotaServicio();
  }

  //Cuando llegue una petición tipo get hará lo sgte
  @GetMapping
  //Si quiero permitir que se ejecute desde otro cliente o conexiones a tercero
  //con * permito todas las conexiones, de lo contrario debo especificar el dominio
  @CrossOrigin("*")
  public List<Mascota> getList() {
    //Creamos un array vacio
    List<Mascota> mascotas = new ArrayList<>();
    try {
      //Decimos que el array será igual a el servicio con su metodo getList
      //El cual almaceno el objeto de la consulta a la db y lo transformó a una lista
      mascotas = servicio.getList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mascotas;
  }

    //Aquí se crea una sub ruta
  @GetMapping("/{id}")
  //Agregamos u decorador para que capture el valor de la url
  //que sería ID y sería de tipo entero
  //Si quiero permitir que se ejecute desde otro cliente o conexiones a tercero
  //con * permito todas las conexiones, de lo contrario debo especificar el dominio
  @CrossOrigin("*")
  public Mascota readById(@PathVariable(name = "id") int id) {
    Mascota mascota = new Mascota();
    try {
      mascota = servicio.readById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mascota;
  }

  @GetMapping("/fullname")
  //Si quiero permitir que se ejecute desde otro cliente o conexiones a tercero
  //con * permito todas las conexiones, de lo contrario debo especificar el dominio
  @CrossOrigin("*")
  public List<Mascota> getByLastname(@RequestParam String nombre, @RequestParam String apellido) {
    List<Mascota> mascotas = new ArrayList<>();
    try {
      mascotas = servicio.getByLastname(nombre, apellido);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mascotas;
  }

  //Enviaremos un objeto mascota
  //No lo pediremos por url sino por el cuerpo de la petición por seguridad
  @PostMapping
  //Si quiero permitir que se ejecute desde otro cliente o conexiones a tercero
  //con * permito todas las conexiones, de lo contrario debo especificar el dominio
  @CrossOrigin("*")
  public String create(@RequestBody Mascota mascota) {
    //Pasará un objeto de tipo mascota
    //posteriormente lo creamos mediante el ORM en mascotaServicio
    return servicio.create(mascota);
  }

    //Put se refiere a actualizar básicamente

  @PutMapping
  //Si quiero permitir que se ejecute desde otro cliente o conexiones a tercero
  //con * permito todas las conexiones, de lo contrario debo especificar el dominio
  @CrossOrigin("*")
  public String update(@RequestBody Mascota mascota) {
    String message = "";
    try {
      servicio.update(mascota);
      message = "Mascota actualizada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
  }

  //Eliminar por id
  @DeleteMapping("/{id}")
  //Si quiero permitir que se ejecute desde otro cliente o conexiones a tercero
  //con * permito todas las conexiones, de lo contrario debo especificar el dominio
  @CrossOrigin("*")
  public String delete(@PathVariable(name = "id") int id) {
    return servicio.delete(id);
  }

}
