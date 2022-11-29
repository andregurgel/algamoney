package br.com.andregurgel.algamoney.service;

import br.com.andregurgel.algamoney.model.Pessoa;
import br.com.andregurgel.algamoney.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa update(Long codigo, Pessoa pessoa) {
        Pessoa oldPessoa = pessoaRepository.findOne(codigo);
        if (nonNull(oldPessoa)) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(pessoa, oldPessoa, "codigo");
        return pessoaRepository.save(oldPessoa);
    }
}
