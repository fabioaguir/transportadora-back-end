package com.hive.transportadora.queriesCustomized;

import com.hive.transportadora.models.Transportadora;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class TransportadoraQueryCustom {

    @PersistenceContext
    private EntityManager entity;

    public List<Transportadora> searchForFilter(String nome, List<Long> ufs, String cidade, List<Long> modals) {

        StringBuilder hql = new StringBuilder();
        hql.append("SELECT obj FROM Transportadora obj WHERE 1 = 1");

        if (!nome.equals(""))
            hql.append(" AND obj.nome like :nome ");

        if (ufs != null)
            hql.append(" AND obj.uf.id IN :uf ");

        if (!cidade.equals(""))
            hql.append(" AND obj.cidade like :cidade ");

        if (modals != null)
            hql.append(" AND obj.modal.id IN :modal ");

        hql.append(" ORDER BY obj.nome ASC ");

        Query query = this.entity.createQuery(hql.toString());

        if (!nome.equals(""))
            query.setParameter("nome", "%" + nome + "%");

        if (ufs != null)
            query.setParameter("uf", ufs);

        if (!cidade.equals(""))
            query.setParameter("cidade", "%" + cidade + "%");

        if (modals != null)
            query.setParameter("modal", modals);

        return query.getResultList();
    }

}
