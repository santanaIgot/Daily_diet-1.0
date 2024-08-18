package br.com.projeto.DailyDiet.dto.usuario;

import br.com.projeto.DailyDiet.model.Usuario;

public record DetalhesUsuarioDto( Long id,String nome, String cpf,
                                 String email, String telefone, String senha) {


    public DetalhesUsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getEmail(),
                usuario.getTelefone(), usuario.getSenha());
    }
}
