package br.com.projeto.DailyDiet.model;

import br.com.projeto.DailyDiet.dto.refeicao.CadastroRefeicaoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "TB_DIETA_REFEICAO")
public class Refeicao {
    @Id
    @GeneratedValue
    @Column(name = "cd_refeicao",unique = true, nullable = false)
    private Long id;
    @Column(name = "nm_nome", nullable = false, unique = true)
    private String nome;
    @Column(name = "dc_descricao", nullable = false)
    private String descricao;
    @Column(name = "dt_refeicao", nullable = false)
    private LocalDate dataRefeicao;

    @ManyToOne()
            @JoinColumn(name = "cd_id_usuario", nullable = false)
    Usuario usuario;


    public Refeicao(CadastroRefeicaoDto dto){
        nome = dto.nome();
        descricao = dto.descricao();
        dataRefeicao = dto.dataRefeicao();
    }
}
