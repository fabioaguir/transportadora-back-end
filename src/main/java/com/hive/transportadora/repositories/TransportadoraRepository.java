package com.hive.transportadora.repositories;

import com.hive.transportadora.models.Modal;
import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.models.UF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Fabio Aguiar
 */
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {

    /*@Query("SELECT obj FROM Transportadora obj WHERE obj.nome like %:nome% OR obj.uf IN :uf OR obj.cidade like %:cidade% OR obj.modal IN :modal ")
    public Page<Transportadora> search(@Param("nome") String nome, @Param("uf") List<UF> listaUf,
                                       @Param("cidade") String bairro, @Param("modal") List<Modal> listaModal, Pageable pageRequest);*/

}
