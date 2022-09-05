package br.com.gymfit.cadastro.cadastro.repositorio;

import br.com.gymfit.cadastro.cadastro.dominio.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {
}
