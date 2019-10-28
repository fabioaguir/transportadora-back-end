package com.hive.transportadora.services;

import com.hive.transportadora.dto.UFForFilterDTO;
import com.hive.transportadora.models.UF;
import com.hive.transportadora.queriesCustomized.UFQueryCustom;
import com.hive.transportadora.repositories.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Fabio Aguiar
 */
@Service
public class UFService {

    @Autowired
    private UFRepository repository;

    @Autowired
    private UFQueryCustom queryCustom;

    public List<UF> findAll() {
        return this.repository.findAll();
    }

    public List<UFForFilterDTO> searchForParamsFilter() {
        return this.queryCustom.searchForParamsFilter();
    }

    /**
     * Método criado para instância dos estado no banco de dados
     */
    public void instanciarUfs() {
        UF uf1 = new UF(null, "Acre", "AC");
        UF uf2 = new UF(null, "Alagoas", "AL");
        UF uf3 = new UF(null, "Amapá", "AP");
        UF uf4 = new UF(null, "Amazonas", "AM");
        UF uf5 = new UF(null, "Bahia", "BA");
        UF uf6 = new UF(null, "Ceará", "CE");
        UF uf7 = new UF(null, "Distrito Federal", "DF");
        UF uf8 = new UF(null, "Espírito Santo", "ES");
        UF uf9 = new UF(null, "Goiás", "GO");
        UF uf10 = new UF(null, "Maranhão", "MA");
        UF uf11 = new UF(null, "Mato Grosso", "MT");
        UF uf12 = new UF(null, "Mato Grosso do Sul", "MS");
        UF uf13 = new UF(null, "Minas Gerais", "MG");
        UF uf14 = new UF(null, "Pará", "PA");
        UF uf15 = new UF(null, "Paraíba", "PB");
        UF uf16 = new UF(null, "Paraná", "PR");
        UF uf17 = new UF(null, "Pernambuco", "PE");
        UF uf18 = new UF(null, "Piauí", "PI");
        UF uf19 = new UF(null, "Rio de Janeiro", "RJ");
        UF uf20 = new UF(null, "Rio Grande do Norte", "RN");
        UF uf21 = new UF(null, "Rio Grande do Sul", "RS");
        UF uf22 = new UF(null, "Rondônia", "RO");
        UF uf23 = new UF(null, "Roraima", "RR");
        UF uf24 = new UF(null, "Santa Catarina", "SC");
        UF uf25 = new UF(null, "São Paulo", "SP");
        UF uf26 = new UF(null, "Sergipe", "SE");
        UF uf27 = new UF(null, "Tocantins", "TO");

        this.repository.saveAll(Arrays.asList(
                uf1, uf2, uf3, uf4, uf5, uf6, uf7, uf8, uf9, uf10, uf11,
                uf12, uf13, uf14, uf15, uf16, uf17, uf18, uf19, uf20, uf21,
                uf22, uf23, uf24, uf25, uf26, uf27
        ));
    }
}
