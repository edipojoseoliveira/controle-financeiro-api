package edi.finance.api.domain.despesa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "despesas")
@Entity(name = "Despesa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Despesa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate vencimento;
    @Enumerated(EnumType.STRING)
    private SituacaoDespesaEnum situacao;
    @Enumerated(EnumType.STRING)
    private GrupoDespesaEnum grupo;
    private Boolean recorrente;
    private Boolean ativo;

    public Despesa(DespesaForm despesaForm) {
        this.descricao = despesaForm.descricao();
        this.valor = despesaForm.valor();
        this.vencimento = despesaForm.vencimento();
        this.situacao = despesaForm.situacao();
        this.grupo = despesaForm.grupo();
        this.recorrente = despesaForm.recorrente();
        this.ativo = true;
    }

    public void atualizar(DespesaEdit despesaEdit) {
        if (despesaEdit.descricao() != null) {
            this.descricao = despesaEdit.descricao();
        }
        if (despesaEdit.valor() != null) {
            this.valor = despesaEdit.valor();
        }
        if (despesaEdit.vencimento() != null) {
            this.vencimento = despesaEdit.vencimento();
        }
        if (despesaEdit.grupo() != null) {
            this.grupo = despesaEdit.grupo();
        }
        if (despesaEdit.recorrente() != null) {
            this.recorrente = despesaEdit.recorrente();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
