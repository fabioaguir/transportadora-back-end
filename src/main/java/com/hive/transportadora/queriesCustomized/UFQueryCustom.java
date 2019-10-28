package com.hive.transportadora.queriesCustomized;

import com.hive.transportadora.dto.UFForFilterDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Fabio Aguiar
 */
@Service
public class UFQueryCustom {

    @PersistenceContext
    private EntityManager entity;

    public List<UFForFilterDTO> searchForParamsFilter() {

        String hql = "SELECT NEW com.hive.transportadora.dto.UFForFilterDTO(uf.id, uf.nome, count(tra.id)) " +
                "FROM Transportadora tra LEFT JOIN tra.uf uf GROUP BY uf.id, uf.nome";

        TypedQuery<UFForFilterDTO> query = this.entity.createQuery(hql, UFForFilterDTO.class);

        return query.getResultList();
    }
}
