package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.FluxoCaixaLogic;
import br.edu.iftm.ecommerce.model.FluxoCaixa;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FluxoCaixaBean extends CrudBean<FluxoCaixa, FluxoCaixaLogic> {

    @Inject
    private FluxoCaixaLogic logic;

    public FluxoCaixaBean() {
        super(FluxoCaixa.class);
    }
    
    @Override
    public FluxoCaixaLogic getLogic() {
        return this.logic;
    }
    
    public List<FluxoCaixa> listaFluxoCaixas(){
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
