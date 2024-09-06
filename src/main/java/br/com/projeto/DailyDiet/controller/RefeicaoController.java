package br.com.projeto.DailyDiet.controller;

import br.com.projeto.DailyDiet.dto.refeicao.CadastroRefeicaoDto;
import br.com.projeto.DailyDiet.dto.refeicao.DetalhesRefeicaoDto;
import br.com.projeto.DailyDiet.model.Refeicao;
import br.com.projeto.DailyDiet.repository.RefeicaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("refeicao")
public class RefeicaoController {
    @Autowired
    private RefeicaoRepository refeicaoRepository;
    @Autowired
    private UserDetailsServiceAutoConfiguration userDetailsServiceAutoConfiguration;


    @Transactional
    @PostMapping("/registrar")
    public ResponseEntity<DetalhesRefeicaoDto> cadastrarRefeicao(@RequestBody CadastroRefeicaoDto dto,
                                                                 UriComponentsBuilder uriBuilder,
                                                                 @AuthenticationPrincipal UserDetails userDetails ) {

        if(userDetails == null || userDetails.getUsername() != null){
            return ResponseEntity.badRequest().build();
        }

        var refeicao = new Refeicao(dto);
        var uri = uriBuilder.path("refeicao/{id}").buildAndExpand(refeicao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesRefeicaoDto(refeicao));
    }
}
