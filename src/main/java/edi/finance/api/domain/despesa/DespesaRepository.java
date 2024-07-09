package edi.finance.api.domain.despesa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    Page<Despesa> findAllByAtivoTrue(Pageable paginacao);

}
