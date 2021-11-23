package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Pagamento;

public class PagamentoRepository  extends GenericRepository<Pagamento, Integer>{

    public PagamentoRepository() {
        super(Pagamento.class);
    }
}
