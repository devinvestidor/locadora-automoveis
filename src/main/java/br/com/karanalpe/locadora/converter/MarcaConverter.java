package br.com.karanalpe.locadora.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.karanalpe.locadora.model.Marca;

@FacesConverter(forClass = Marca.class)
public class MarcaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComponent, Object value) {
		if (value instanceof Marca) {
			Marca marca = (Marca) value;
			if (marca != null && marca instanceof Marca && marca.getId() != null) {
				uiComponent.getAttributes().put(marca.getId().toString(), marca);
				return marca.getId().toString();
			}
		}
		return "";
	}

}
