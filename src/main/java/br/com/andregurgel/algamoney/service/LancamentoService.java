package br.com.andregurgel.algamoney.service;

import br.com.andregurgel.algamoney.model.Lancamento;
import br.com.andregurgel.algamoney.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }

    public Lancamento findOne(Long codigo) {
        return lancamentoRepository.findOne(codigo);
    }
}
