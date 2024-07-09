package edi.finance.api.domain.despesa;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaEdit(
        @NotNull
        Long id,
        String descricao,
        BigDecimal valor,
        LocalDate vencimento,
        GrupoDespesaEnum grupo,
        Boolean recorrente
) {
}
