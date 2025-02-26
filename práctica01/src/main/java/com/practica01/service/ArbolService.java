
package com.practica01.service;


import com.practica01.domain.Arbol;
import java.util.List;

public interface ArbolService {
    List<Arbol> getArboles();
    void save(Arbol arbol);
    void delete(Arbol arbol);
    Arbol getArbol(Long id);
}
