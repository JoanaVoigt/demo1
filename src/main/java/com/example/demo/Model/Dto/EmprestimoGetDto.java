package com.example.demo.Model.Dto;

import java.util.List;

public record EmprestimoGetDto(
        String dataEmprestimo,
        String dataDevolucao,
        Long usuarioId,
        List<Long> livrosId
) {
}
