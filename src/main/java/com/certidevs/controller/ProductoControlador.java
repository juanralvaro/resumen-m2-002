package com.certidevs.spring_002_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ProductoControlador {

    @GetMapping("ejemplo")
    public String producto(Model model) {
        model.addAttribute("ejemplo", "Frase de ejemplo");
        return "ejemplo";
    }

    @GetMapping("producto-detalle")
    public String productoDetalle(Model model) {

        Producto aceiteGirasol = new Producto(1L, "Aceite de Girasol AOVE", 2.50, true, "Comida");
        model.addAttribute("producto", aceiteGirasol);

        Producto vinagreNormal = new Producto(2L, "Vinagre Normal", 0.65, false, "Comida");
        model.addAttribute("producto2", vinagreNormal);

        return "producto-detalle";
    }

    @GetMapping("producto-lista")
    public String productoLista(Model model) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1L, "Aceite de Girasol AOVE", 2.50, true, "Comida"));
        productos.add(new Producto(2L, "Vinagre Normal", 0.65, false, "Comida"));
        productos.add(new Producto(3L, "Tomate", 1.50, true, "Comida"));
        productos.add(new Producto(4L, "Coca-Cola 2L", 2.00, true, "Comida"));
        model.addAttribute("productos", productos);
        return "producto-lista";

    }
}
