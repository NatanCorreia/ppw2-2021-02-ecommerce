package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.PagamentoLogic;
import br.edu.iftm.ecommerce.model.Pagamento;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PagamentoBean extends CrudBean<Pagamento, PagamentoLogic> {

    @Inject
    private PagamentoLogic logic;

    public PagamentoBean() {
        super(Pagamento.class);
    }
    
    @Override
    public PagamentoLogic getLogic() {
        return this.logic;
    }
    
    public List<Pagamento> listaPagamentos(){
        try {
            return this.logic.buscar(null);
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }
    
    
    
}
