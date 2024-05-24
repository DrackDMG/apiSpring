package com.demo.controller;

import com.demo.entity.Nota;
import com.demo.model.MNota;
import com.demo.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class NotaController {

    @Autowired
    @Qualifier("servicio")
    NotaService servicio;

    @PostMapping("/nota")
    public boolean agregarNota(@RequestBody Nota nota){
        return servicio.crear(nota);
    }
    @PutMapping("/nota")
    public boolean actualizarNota(@RequestBody Nota nota){
        return servicio.actualizar(nota);
    }
    @DeleteMapping("/nota/{nombre}/{id}")
    public boolean borrarNota(@PathVariable("nombre") String nombre, @PathVariable("id") Long id){
        return servicio.borrar(nombre, id);
    }
    @GetMapping("/nota")
    public List<MNota> obtenerNotas(Pageable pageable){
        return servicio.obtenerPorPaginacion(pageable);
    }
    @GetMapping("/nota/{nombre}/{titulo}")
    public MNota obtenerNotaPorNombreYTitulo(@PathVariable("nombre") String nombre, @PathVariable("titulo") String titulo){
        return servicio.obtenerPorNombreYTitulo(nombre, titulo);
    }
    @GetMapping("/nota/{titulo}")
    public List<MNota> obtenerNotaPorTitulo(@PathVariable("titulo") String titulo){
        return servicio.obtenerPorTitulo(titulo);
    }
    @GetMapping("/nota/name/{nombre}")
    public MNota obtenerNotaPorNombre(@PathVariable("nombre") String nombre){
        return servicio.obtenerPorNombre(nombre);
    }


}
