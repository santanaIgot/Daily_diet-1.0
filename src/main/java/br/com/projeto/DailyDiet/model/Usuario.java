package br.com.projeto.DailyDiet.model;


import br.com.projeto.DailyDiet.dto.usuario.CadastroUsuarioDto;
import jakarta.persistence.*;
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
    @Column(name = "cd_id")
    private Long id;
    @Column(name = "nm_nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "cpf")
    private String cpf;

    public Usuario(CadastroUsuarioDto dto) {
        nome = dto.nome();
        email = dto.email();
        senha = dto.senha();
        telefone = dto.telefone();
        cpf = dto.cpf();

    }
}
