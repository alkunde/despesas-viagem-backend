package ufpr.andrekunde.despesasviagem.resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpr.andrekunde.despesasviagem.model.Contato;
import ufpr.andrekunde.despesasviagem.repository.Contatos;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatosResource {

    @Autowired
    private Contatos contatos;

    @PostMapping
    public Contato adicionar(@Valid @RequestBody Contato contato) {
        return contatos.save(contato);
    }

    @GetMapping
    public List<Contato> listar() {
        return contatos.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscar(@PathVariable Long id) {
        Contato contato = contatos.getOne(id);

        if (contato == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Contato contato
    ) {
        Contato existente = contatos.getOne(id);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(contato, existente, "id");

        existente = contatos.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Contato contato = contatos.getOne(id);

        if (contato == null) {
            return ResponseEntity.notFound().build();
        }

        contatos.delete(contato);

        return ResponseEntity.noContent().build();
    }
}
