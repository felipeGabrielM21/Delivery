package com.Delivery.controller;

import com.Delivery.model.DadosParaListar;
import com.Delivery.model.DadosParaPedido;
import com.Delivery.model.Pedido;
import com.Delivery.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody @Valid DadosParaPedido dados, UriComponentsBuilder builder) {
        var pedido = new Pedido(dados);
        repository.save(pedido);

        var uri = builder.path("/cadastro/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<DadosParaListar> listar(@PathVariable Long id) {
        var listarPedido = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosParaListar(listarPedido));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id) {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não existe");
        }

        repository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
}
