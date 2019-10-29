package com.hive.transportadora.repositories;

import com.hive.transportadora.models.Modal;
import com.hive.transportadora.models.Transportadora;
import com.hive.transportadora.models.UF;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fabio Aguiar
 */
@SpringBootTest
class TransportadoraRepositoryTest {
    @Autowired
    private TransportadoraRepository repository;

    @Autowired
    private UFRepository ufRepository;

    @Autowired
    private ModalRepository modalRepository;

    @Test
    void createTransportadora() throws Exception {
        Transportadora transportadora = this.getInstanceTransportadora();
        this.repository.save(transportadora);

        assertNotNull(transportadora.getId());
    }

    @Test
    void deleteTransportadora() throws Exception {
        Transportadora transportadora = this.getInstanceTransportadora();
        this.repository.save(transportadora);
        this.repository.delete(transportadora);

        Optional<Transportadora> byId = this.repository.findById(transportadora.getId());
        assertNull(byId.orElse(null));
    }

    @Test
    void updateTransportadora() throws Exception {
        Transportadora transportadora = this.getInstanceTransportadora();
        this.repository.save(transportadora);

        transportadora.setNome("HiveLog2");
        transportadora.setEmpresa("Hive2");
        this.repository.save(transportadora);

        Optional<Transportadora> byId = this.repository.findById(transportadora.getId());
        Transportadora transportadoraUpdated = byId.get();

        assertEquals(transportadoraUpdated.getNome(), "HiveLog2");
        assertEquals(transportadoraUpdated.getEmpresa(), "Hive2");
    }

    private Transportadora getInstanceTransportadora() {
        Optional<UF> uf = this.ufRepository.findById(17L);
        Optional<Modal> modal = this.modalRepository.findById(1L);

        return new Transportadora(null,
                "hive.log@gmail.com",
                "HiveLog",
                "Hive",
                "33542831000144",
                "8198673359",
                "8198673359",
                "8198673359",
                "53620200",
                "Igarassu",
                "Encanto Igarassu",
                "Avenida Maria Rita",
                "500",
                true,
                modal.get(),
                uf.get()
        );
    }
}
