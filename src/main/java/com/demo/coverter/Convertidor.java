package com.demo.coverter;

import com.demo.entity.Nota;
import com.demo.model.MNota;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("convertidor")
public class Convertidor {
    public List<MNota> convertirLista(List<Nota> notas){
        List<MNota> mNotas = new ArrayList<>();
        mNotas = notas.stream().map(MNota::new).collect(Collectors.toList());
       /*
       for (Nota nota: notas){
            mNotas.add(new MNota(nota));
        }
        */
        return mNotas;
    }
}
