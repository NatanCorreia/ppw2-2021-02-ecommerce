package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Pagamento;
import br.edu.iftm.ecommerce.repository.PagamentoRepository;
import br.edu.iftm.ecommerce.util.StringUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class PagamentoLogic implements CrudLogic<Pagamento>{

    @Inject
    private PagamentoRepository reporitory;
    
    @Override
    public Pagamento salvar(Pagamento entidade) throws ErroSistemaException, ErroNegocioException {
        if(StringUtil.isEmpty(entidade.getNome())) {
            throw new ErroNegocioException("Informe o nome.");
        }
        return this.reporitory.save(entidade);
    }

    @Override
    public void remover(Pagamento entidade) throws ErroSistemaException, ErroNegocioException {
        this.reporitory.remove(entidade.getId());
    }

    @Override
    public Pagamento buscarPorId(Pagamento entidade) throws ErroSistemaException, ErroNegocioException {
        return this.reporitory.findByID(entidade.getId());
    }

    @Override
    public List<Pagamento> buscar(Pagamento entidade) throws ErroSistemaException, ErroNegocioException {
        return this.reporitory.list();
    }
    
}
