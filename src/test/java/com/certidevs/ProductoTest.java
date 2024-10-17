package com.certidevs.spring_002_mvc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    void LombokGetterSetterTest() {
        Producto producto1 = new Producto();
        producto1.setNombre("Prueba");
        producto1.setPrecio(49.99);
        assertEquals("Prueba", producto1.getNombre());
        assertEquals(49.99, producto1.getPrecio());
    }

    @Test
    void LombokConstructor() {
        Producto producto1 = new Producto(1L, "ordenador", 499.99, true, "Tecnología");
        System.out.println(producto1);
        assertEquals("Producto(id=1, nombre=ordenador, precio=499.99, activo=true, categoria=Tecnología)", producto1.toString());
    }

    @Test
    void LombokBuilder() {
        // Patrón de diseño Builder que existe en general para todos los lenguajes
        // En este caso el Builder nos lo proporciona la librería Lombok
        Producto producto1 = new Producto.ProductoBuilder()
                .id(1L)
                .nombre("laptop")
                .precio(299.99)

                .build();

        Producto producto2 = new Producto.ProductoBuilder()
                .precio(399.99)
                .id(2L)
                .build();

        Producto producto3 = new Producto(2L, null, 399.00, true, "Tecnología");
    }

}