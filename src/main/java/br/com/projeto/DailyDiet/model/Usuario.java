package br.com.projeto.DailyDiet.model;


import br.com.projeto.DailyDiet.dto.usuario.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO_DIET" )
@Getter@Setter
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        senha = passwordEncoder.encode(dto.senha());
        telefone = dto.telefone();
        cpf = dto.cpf();

    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
