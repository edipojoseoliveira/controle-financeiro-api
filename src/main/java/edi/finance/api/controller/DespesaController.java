package edi.finance.api.controller;

import edi.finance.api.domain.despesa.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DespesaResp> cadastrar(@RequestBody @Valid DespesaForm despesaForm, UriComponentsBuilder uriBuilder) {
        var despesa = new Despesa(despesaForm);
        repository.save(despesa);

        var uri = uriBuilder.path("/despesas/{id}").buildAndExpand(despesa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DespesaResp(despesa));
    }

    @GetMapping
    public ResponseEntity<Page<DespesaDTO>> listar(@PageableDefault(size = 10, sort = {"grupo"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DespesaDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DespesaResp> atualizar(@RequestBody @Valid DespesaEdit despesaEdit) {
        var despesa = repository.getReferenceById(despesaEdit.id());
        despesa.atualizar(despesaEdit);
        return ResponseEntity.ok(new DespesaResp(despesa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var despesa = repository.getReferenceById(id);
        despesa.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaResp> detalhar(@PathVariable Long id) {
        var despesa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DespesaResp(despesa));
    }

}
