package com.practica01.controller;


import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String listadoArboles(Model model) {
        model.addAttribute("arboles", arbolService.getArboles());
        return "templates.arbol.listado";
    }

    @GetMapping("/nuevo")
    public String nuevoArbol(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "templates.arbol.formulario";
    }

    @PostMapping("/guardar")
    public String guardarArbol(Arbol arbol) {
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/editar/{id}")
    public String editarArbol(@PathVariable("id") Long id, Model model) {
        model.addAttribute("arbol", arbolService.getArbol(id));
        return "templates.arbol.formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArbol(@PathVariable("id") Long id) {
        Arbol arbol = arbolService.getArbol(id);
        if (arbol != null) {
            arbolService.delete(arbol);
        }
        return "redirect:/arbol/listado";
    }
}
