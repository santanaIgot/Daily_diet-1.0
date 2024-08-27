package br.com.projeto.DailyDiet.dto.usuario;

import br.com.projeto.DailyDiet.model.Usuario;

public record DetalhesUsuarioDto( Long id,String login) {


    public DetalhesUsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin());
    }
}
