package br.edu.iftm.ecommerce.bean.converter;

import br.edu.iftm.ecommerce.logic.PagamentoLogic;
import br.edu.iftm.ecommerce.model.Pagamento;
import br.edu.iftm.ecommerce.repository.PagamentoRepository;
import br.edu.iftm.ecommerce.util.JSFUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Pagamento.class)
public class PagamentoConverter extends JSFUtil implements Converter<Pagamento>{

    @Inject
    private PagamentoLogic logic;
    
    @Override
    public Pagamento getAsObject(FacesContext fc, UIComponent uic, String idString) {
       Pagamento pagamento = 
                    (Pagamento)uic.getAttributes().get("pagamento_"+idString);
       return pagamento;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Pagamento pagamento) {
        if(pagamento != null && pagamento.getId() != null){
            uic.getAttributes().put("pagamento_"+pagamento.getId(), pagamento);
            return pagamento.getId().toString();
        }
        return "";
    }
    
}
