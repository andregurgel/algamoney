package br.com.andregurgel.algamoney.resource;

import br.com.andregurgel.algamoney.model.Categoria;
import br.com.andregurgel.algamoney.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Categoria findOne(@PathVariable Long categoriaId) {
        return categoriaRepository.findOne(categoriaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria insert(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
