package com.certidevs.controller;

import com.certidevs.model.Ropa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class RopaController {

    ArrayList<Ropa> ropas = new ArrayList<>();

    public RopaController() {
        ropas.add(new Ropa(1L, "camisa", "XL", "poliéster"));
        ropas.add(new Ropa(2L, "jersey", "M", "lana"));
    }

    //http://localhost:8080/prendas
    @GetMapping("ropas")
    public String listaDeRopas(Model model) {
        model.addAttribute("ropas", ropas);
        return "ropa-list";
    }

    @GetMapping("ropas/{id}")
    public String detalleDePrendas(@PathVariable Long id, Model model) {

        Ropa ropaEncontrada = null;
        for (Ropa ropa : ropas) {
            if (ropa.getId().equals(id))
                ropaEncontrada = ropa;
        }
        if (ropaEncontrada != null) {
            model.addAttribute("ropa", ropaEncontrada);
            return "ropa-detail";
        } else {
            return "no-encontrado";
        }

    }

    @GetMapping("ropas/form")
    public String formularioRopa(Model model) {
        model.addAttribute("ropa", new Ropa());
        return "ropa-form";
    }

    @GetMapping("ropas/form/{id}")
    public String formularioRopaUpdate(@PathVariable Long id, Model model) {
        Optional<Ropa> ropaOptional = ropas.stream().filter(ropa -> ropa.getId().equals(id)).findFirst();
        if (ropaOptional.isEmpty())
            return "not-found";

        Ropa ropa = ropaOptional.get();
        model.addAttribute("ropa", ropa);
        return "ropa-form";
    }

    @PostMapping("ropas")
    public String saveRopa(@ModelAttribute Ropa ropaDeFormulario) {
        Optional<Ropa> ropaOptional = ropas.stream().filter(r -> r.getId().equals(ropaDeFormulario.getId())).findFirst();
        if (ropaOptional.isEmpty()) {
            ropas.add(ropaDeFormulario);
            return "redirect:/ropas";
        }

        Ropa ropaDelArrayList = ropaOptional.get();
        ropaDelArrayList.setNombre(ropaDeFormulario.getNombre());
        ropaDelArrayList.setTamano(ropaDeFormulario.getTamano());
        ropaDelArrayList.setMaterial(ropaDeFormulario.getMaterial());
        return "redirect:/ropas";
    }

    @GetMapping("ropas/delete/{id}")
    public String deleteRopa(@PathVariable Long id, Model model) {
        ropas.removeIf(r -> r.getId().equals(id));
        return "redirect:/ropas";
    }

}
