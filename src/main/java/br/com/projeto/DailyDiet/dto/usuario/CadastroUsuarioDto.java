package br.com.projeto.DailyDiet.dto.usuario;

public record CadastroUsuarioDto(Long id, String nome, String cpf,
                                 String email, String telefone, String senha) {

}
