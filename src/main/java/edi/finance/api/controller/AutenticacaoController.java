package edi.finance.api.controller;

import edi.finance.api.domain.usuario.LoginDTO;
import edi.finance.api.domain.usuario.Usuario;
import edi.finance.api.infra.security.DadosTokenJWT;
import edi.finance.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid LoginDTO login) {
        var userAuthentication = new UsernamePasswordAuthenticationToken(login.login(), login.senha());
        var authentication = manager.authenticate(userAuthentication);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
