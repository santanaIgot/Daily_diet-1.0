package br.com.projeto.DailyDiet.controller;

import br.com.projeto.DailyDiet.dto.usuario.CadastroUsuarioDto;
import br.com.projeto.DailyDiet.dto.usuario.DetalhesUsuarioDto;
import br.com.projeto.DailyDiet.model.Usuario;
import br.com.projeto.DailyDiet.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping("registrar")
    public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody CadastroUsuarioDto dto,
                                                   UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dto);
        usuarioRepository.save(usuario);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return  ResponseEntity.created(uri).body(new DetalhesUsuarioDto(usuario));
    }
}
