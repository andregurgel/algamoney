package br.com.andregurgel.algamoney.resource;

import br.com.andregurgel.algamoney.model.Lancamento;
import br.com.andregurgel.algamoney.repository.lancamento.LancamentoFilter;
import br.com.andregurgel.algamoney.repository.lancamento.LancamentoRepository;
import br.com.andregurgel.algamoney.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping
    public ResponseEntity<List<Lancamento>> findAll() {
        return ResponseEntity.ok(lancamentoService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Lancamento>> findAllFiltered(@RequestBody LancamentoFilter lancamentoFilter) {
        return ResponseEntity.ok(lancamentoService.findAllFiltered(lancamentoFilter));
    }

    @GetMapping("/{lancamentoId}")
    public ResponseEntity<Lancamento> findById(@PathVariable Long lancamentoId) {
        Lancamento lancamento = lancamentoService.findById(lancamentoId);
        if (nonNull(lancamento)) {
            return ResponseEntity.ok(lancamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lancamento insert(@Valid @RequestBody Lancamento lancamento) {
        return lancamentoService.insert(lancamento);
    }

    @DeleteMapping("/{pessoaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long pessoaId) {
        lancamentoRepository.deleteById(pessoaId);
    }
}
