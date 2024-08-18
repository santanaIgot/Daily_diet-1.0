package br.com.projeto.DailyDiet.repository;

import br.com.projeto.DailyDiet.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
