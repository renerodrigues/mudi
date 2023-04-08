package br.com.alura.mvc.mudi.utilities;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PaginacaoOrdenada{
   
    public static Pageable porIdDesc() {
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);
        return paginacao;
    }
}
