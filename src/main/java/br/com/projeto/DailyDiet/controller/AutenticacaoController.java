package br.com.projeto.DailyDiet.controller;

import br.com.projeto.DailyDiet.dto.autenticacao.DadosAutenticacaoDto;
import br.com.projeto.DailyDiet.dto.autenticacao.DadosTokenJWTDto;
import br.com.projeto.DailyDiet.model.Usuario;
import br.com.projeto.DailyDiet.service.TokenService;
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
    public ResponseEntity<DadosTokenJWTDto> login(@RequestBody DadosAutenticacaoDto dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autentication = manager.authenticate(token);
        var tokenJwt = tokenService.gerarToken((Usuario) autentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWTDto((tokenJwt)));

    }
}
