package br.com.andregurgel.algamoney.repository.lancamento;

import br.com.andregurgel.algamoney.model.Lancamento;

import java.util.List;

public interface LancamentoRepositoryQuery {
    public List<Lancamento> filter(LancamentoFilter lancamentoFilter);
}
