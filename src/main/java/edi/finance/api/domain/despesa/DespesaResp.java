package edi.finance.api.domain.despesa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaResp(
        Long id,
        String descricao,
        BigDecimal valor,
        LocalDate vencimento,
        SituacaoDespesaEnum situacao,
        GrupoDespesaEnum grupo,
        Boolean recorrente,
        Boolean ativo
) {

    public DespesaResp(Despesa despesa) {
        this(despesa.getId(),
            despesa.getDescricao(),
            despesa.getValor(),
            despesa.getVencimento(),
            despesa.getSituacao(),
            despesa.getGrupo(),
            despesa.getRecorrente(),
            despesa.getAtivo());
    }

}
