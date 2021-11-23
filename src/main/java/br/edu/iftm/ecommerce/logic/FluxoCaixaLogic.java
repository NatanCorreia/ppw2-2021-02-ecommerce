package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.FluxoCaixa;
import br.edu.iftm.ecommerce.repository.FluxoCaixaRepository;
import br.edu.iftm.ecommerce.util.StringUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class FluxoCaixaLogic implements CrudLogic<FluxoCaixa>{

    @Inject
    private FluxoCaixaRepository reporitory;
    
    @Override
    public FluxoCaixa salvar(FluxoCaixa entidade) throws ErroSistemaException, ErroNegocioException {
        if(StringUtil.isEmpty(entidade.getDescricao())) {
            throw new ErroNegocioException("Informe a Descrição.");
        }
        return this.reporitory.save(entidade);
    }

    @Override
    public void remover(FluxoCaixa entidade) throws ErroSistemaException, ErroNegocioException {
        this.reporitory.remove(entidade.getId());
    }

    @Override
    public FluxoCaixa buscarPorId(FluxoCaixa entidade) throws ErroSistemaException, ErroNegocioException {
        return this.reporitory.findByID(entidade.getId());
    }

    @Override
    public List<FluxoCaixa> buscar(FluxoCaixa entidade) throws ErroSistemaException, ErroNegocioException {
        return this.reporitory.list();
    }
    
}
