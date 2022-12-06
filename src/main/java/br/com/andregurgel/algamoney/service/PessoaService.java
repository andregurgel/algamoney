package br.com.andregurgel.algamoney.service;

import br.com.andregurgel.algamoney.model.Pessoa;
import br.com.andregurgel.algamoney.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa update(Long codigo, Pessoa pessoa) {
        Pessoa oldPessoa = findById(codigo);
        BeanUtils.copyProperties(pessoa, oldPessoa, "codigo");
        return pessoaRepository.save(oldPessoa);
    }

    public void updateAtivo(Long codigo, Boolean ativo) {
        Pessoa oldPessoa = findById(codigo);
        oldPessoa.setAtivo(ativo);
        pessoaRepository.save(oldPessoa);
    }

    public Pessoa findById(Long codigo) {
        Pessoa oldPessoa = pessoaRepository.findById(codigo).orElseThrow(null);
        if (isNull(oldPessoa)) {
            throw new EmptyResultDataAccessException(1);
        }
        return oldPessoa;
    }
}
