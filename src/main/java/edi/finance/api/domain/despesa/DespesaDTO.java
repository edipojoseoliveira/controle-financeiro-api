package edi.finance.api.domain.despesa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        LocalDate vencimento,
        GrupoDespesaEnum grupo
) {

    public DespesaDTO(Despesa despesa) {
        this(
                despesa.getId(),
                despesa.getDescricao(),
                despesa.getValor(),
                despesa.getVencimento(),
                despesa.getGrupo()
        );
    }

}
