package com.demo.service;

import com.demo.coverter.Convertidor;
import com.demo.entity.Nota;
import com.demo.model.MNota;
import com.demo.repository.NotaRepo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicio")
public class NotaService  {
    @Autowired
    @Qualifier("repositorio")
    private NotaRepo repositorio;

    @Autowired
    @Qualifier("convertidor")
    private Convertidor convertidor;

    private  static final Log logger = LogFactory.getLog(NotaService.class);

    public boolean crear(Nota nota){
        logger.info("Creando nota");
        try {
            repositorio.save(nota);
            logger.info("Nota creada");
            return true;
        } catch (Exception e){
            logger.error("Error al crear la nota");
            return false;
        }
    }
    public boolean actualizar(Nota nota){
        logger.info("Actualizando nota");
        try {
            repositorio.save(nota);
            logger.info("Nota actualizada");
            return true;
        } catch (Exception e){
            logger.error("Error al actualizar la nota");
            return false;
        }
    }
    public boolean borrar(String nombre, Long id){
        logger.warn("Borrando nota");
        try {
            Nota nota = repositorio.findByNombreAndId(nombre, id);
            repositorio.delete(nota);
            logger.info("Nota borrada");
            return true;
        } catch (Exception e){
            logger.error("Error al borrar la nota");
            return false;
        }
    }

    public List<MNota> obtener(){

        return convertidor.convertirLista(repositorio.findAll());
    }

    public MNota obtenerPorNombreYTitulo(String nombre, String titulo){
        return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
    }

    public List<MNota> obtenerPorTitulo(String titulo){
        return convertidor.convertirLista(repositorio.findByTitulo(titulo));
    }
    public MNota obtenerPorNombre(String nombre){
        return new MNota(repositorio.findByNombre(nombre));
    }
    public List<MNota> obtenerPorPaginacion(Pageable pageable){
        return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
    }
}
