package br.com.projeto.DailyDiet.dto.refeicao;

import br.com.projeto.DailyDiet.controller.RefeicaoController;
import br.com.projeto.DailyDiet.model.Refeicao;

import java.time.LocalDate;

public record DetalhesRefeicaoDto(String nome, String descricao, LocalDate dataRefeicao) {
    public DetalhesRefeicaoDto(Refeicao refeicao){
        this(refeicao.getNome(), refeicao.getDescricao(), refeicao.getDataRefeicao());
    }
}
