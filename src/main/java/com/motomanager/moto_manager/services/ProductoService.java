package com.motomanager.moto_manager.services;

import com.motomanager.moto_manager.entities.Producto;
import com.motomanager.moto_manager.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository
    productoRepository;

    public List<Producto> listarTodos(){
        return productoRepository.findAll();
    }


    public Producto guardarProducto(Producto producto){
        if (producto.getStockActual() < 0){
            System.out.println("Lo siento, no puedes guardar productos negativos.");
            producto.setStockActual(0);
        }
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }

    public Producto buscarPorId(Long id){
        return productoRepository.findById(id).orElse(null);
    }


}
