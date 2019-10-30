package com.hive.transportadora.repositories;

import com.hive.transportadora.models.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Fabio Aguiar
 */
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {

    @Query("SELECT obj FROM Transportadora obj WHERE (:nome is null or obj.nome like %:nome% ) " +
            " AND (replace(:uf, ',') is null or obj.uf.id IN (:uf)) " +
            " AND (:cidade is null or obj.cidade like %:cidade%) " +
            " AND (:modal is null or obj.modal.id IN (:modal)) ")
    public List<Transportadora> search(@Param("nome") String nome, @Param("uf") List<Long> listaUf,
                                       @Param("cidade") String bairro, @Param("modal") List<Long> listaModal);

}
