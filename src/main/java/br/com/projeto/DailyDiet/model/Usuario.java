package br.com.projeto.DailyDiet.model;


import br.com.projeto.DailyDiet.dto.usuario.CadastroUsuarioDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_USUARIO_DIET" )
@Getter@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cpf;

    public Usuario(CadastroUsuarioDto dto) {
        nome = dto.nome();
        email = dto.email();
        senha = dto.senha();
        telefone = dto.telefone();
        cpf = dto.cpf();

    }
}
