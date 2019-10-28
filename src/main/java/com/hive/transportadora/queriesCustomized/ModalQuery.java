package com.hive.transportadora.queriesCustomized;

import com.hive.transportadora.dto.ModalForFilterDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ModalQuery {

    @PersistenceContext
    private EntityManager entity;

    public List<ModalForFilterDTO> searchForParamsFilter() {

        String hql = "SELECT NEW com.hive.transportadora.dto.ModalForFilterDTO(modal.id, modal.nome, count(tra.id)) " +
                "FROM Modal modal LEFT JOIN modal.transportadoras tra GROUP BY modal.id, modal.nome";

        TypedQuery<ModalForFilterDTO> query = this.entity.createQuery(hql, ModalForFilterDTO.class);

        return query.getResultList();
    }
}
