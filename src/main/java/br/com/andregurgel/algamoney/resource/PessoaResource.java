package br.com.andregurgel.algamoney.resource;

import br.com.andregurgel.algamoney.model.Categoria;
import br.com.andregurgel.algamoney.model.Pessoa;
import br.com.andregurgel.algamoney.repository.CategoriaRepository;
import br.com.andregurgel.algamoney.repository.PessoaRepository;
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
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<?> findOne(@PathVariable Long pessoaId) {
        Pessoa pessoa = pessoaRepository.findOne(pessoaId);
        if (nonNull(pessoa)) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa insert(@Valid @RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
