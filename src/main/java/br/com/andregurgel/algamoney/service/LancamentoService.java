package br.com.andregurgel.algamoney.service;

import br.com.andregurgel.algamoney.model.Lancamento;
import br.com.andregurgel.algamoney.model.Pessoa;
import br.com.andregurgel.algamoney.repository.LancamentoRepository;
import br.com.andregurgel.algamoney.service.exception.PessoaInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaService pessoaService;

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }

    public Lancamento findById(Long codigo) {
        return lancamentoRepository.findById(codigo).orElseThrow(null);
    }

    public Lancamento insert(Lancamento lancamento) {
        Pessoa pessoa = pessoaService.findById(lancamento.getPessoa().getCodigo());
        if (!pessoa.getAtivo()) {
            throw new PessoaInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }
}
