package edi.finance.api.domain.despesa;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaForm(
        @NotBlank(message = "{descricao.obrigatoria}")
        String descricao,
        @NotNull(message = "{valor.obrigatorio}")
        @DecimalMin(value = "0.0", inclusive = false, message = "{valor.invalido}")
        BigDecimal valor,
        @NotNull(message = "{vencimento.obrigatorio}")
        LocalDate vencimento,
        @NotNull(message = "{situacao.obrigatoria}")
        SituacaoDespesaEnum situacao,
        @NotNull(message = "{grupo.obrigatorio}")
        GrupoDespesaEnum grupo,
        @NotNull(message = "{recorrente.obrigatorio}")
        Boolean recorrente
) {
}
