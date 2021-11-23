package br.edu.iftm.ecommerce.bean.converter;

import br.edu.iftm.ecommerce.logic.FluxoCaixaLogic;
import br.edu.iftm.ecommerce.model.FluxoCaixa;
import br.edu.iftm.ecommerce.repository.FluxoCaixaRepository;
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

@FacesConverter(forClass = FluxoCaixa.class)
public class FluxoCaixaConverter extends JSFUtil implements Converter<FluxoCaixa>{

    @Inject
    private FluxoCaixaLogic logic;
    
    @Override
    public FluxoCaixa getAsObject(FacesContext fc, UIComponent uic, String idString) {
       FluxoCaixa fluxoCaixa = 
                    (FluxoCaixa)uic.getAttributes().get("fluxoCaixa_"+idString);
       return fluxoCaixa;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, FluxoCaixa fluxoCaixa) {
        if(fluxoCaixa != null && fluxoCaixa.getId() != null){
            uic.getAttributes().put("fluxoCaixa_"+fluxoCaixa.getId(), fluxoCaixa);
            return fluxoCaixa.getId().toString();
        }
        return "";
    }
    
}
