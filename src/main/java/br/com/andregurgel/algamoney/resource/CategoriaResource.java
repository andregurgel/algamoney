package br.com.andregurgel.algamoney.resource;

import br.com.andregurgel.algamoney.model.Categoria;
import br.com.andregurgel.algamoney.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<?> findOne(@PathVariable Long categoriaId) {
        Categoria categoria = categoriaRepository.findOne(categoriaId);
        if (nonNull(categoria)) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria insert(@Valid @RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
