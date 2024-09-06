package br.com.projeto.DailyDiet.dto.refeicao;

import java.time.LocalDate;

public record CadastroRefeicaoDto(String nome, String descricao, LocalDate dataRefeicao) {

}
