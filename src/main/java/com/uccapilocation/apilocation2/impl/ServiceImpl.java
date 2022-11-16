package com.uccapilocation.apilocation2.impl;

import com.uccapilocation.apilocation2.model.ApiLocationResponse;
import localhost.service.schema.GetLocationRequest;
import localhost.service.schema.GetLocationResponse;
import localhost.service.schema.GetLocationUniqueRequest;
import localhost.service.schema.GetLocationUniqueResponse;
import localhost.service.wsdl.ServicePort;
import org.apache.cxf.annotations.SchemaValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@SchemaValidation(type = SchemaValidation.SchemaValidationType.REQUEST)
public class ServiceImpl  implements ServicePort {

    @Value("${api.key}")
    private String API_KEY;

    @Override
    public GetLocationResponse getLocation(GetLocationRequest parameters) {
        GetLocationResponse response = new GetLocationResponse();

        // Llamamos al metodo que retorna el objeto con lo datos cargados
        ApiLocationResponse json = getLocationApi(parameters.getLat(), parameters.getLng());

        if (json == null){
            System.out.println("json null.");
            response.setResult("");
            return response;
        }

        String respuesta = json.results.get(0).formatted_address;
        response.setResult(respuesta);

        return response;
    }

    @Override
    public GetLocationUniqueResponse getLocationUnique(GetLocationUniqueRequest parameters) {
        System.out.println("inicia getLocationUnique");
        GetLocationUniqueResponse response = new GetLocationUniqueResponse();
        String latlgn = parameters.getLatlng();
        System.out.println("latlgn: "+latlgn);

        // Validamos el campo es vacio
        if ("".equals(latlgn) || latlgn == null){
            response.setResult("");
            return response;
        }

        // Nos encargamos de organizar el dato para enviarlo a la API
        latlgn = latlgn.replace("(","");
        latlgn = latlgn.replace(")","");
        latlgn = latlgn.replace(" ","");


        // dividimos el string por la coma
        System.out.println("latlgn Antes Split: "+latlgn);
        String[] parametros = latlgn.split(",");

        // se valida que el arreglo cuente con dos caracteres
        if(parametros.length != 0){
            System.out.println("paraetros no valido. latlgn: "+latlgn);
            response.setResult("");
            return response;
        }

        // Llamamos al metodo que retorna el objeto con lo datos cargados
        ApiLocationResponse json = getLocationApi(parametros[0],parametros[1]);
        if (json == null){
            System.out.println("json null.");
            response.setResult("");
            return response;
        }
        String respuesta = json.results.get(0).formatted_address;
        response.setResult(respuesta);

        return response;
    }

    public ApiLocationResponse getLocationApi(String lat, String lng){
        System.out.println("lat: "+lat);
        System.out.println("lng: "+lng);

        // Se validan que los parametros sean validos
        if(lat.replaceAll("[0-9.-]","").length()>0){
            System.out.println("lat no permitido: "+lat);
            return null;
        }
        if(lng.replaceAll("[0-9.-]","").length()>0){
            System.out.println("lng no permitido: "+lng);
            return null;
        }

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        try {
            String ruta = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&key="+API_KEY;
            System.out.println("ruta: "+ruta);
            ApiLocationResponse response = restTemplate.getForObject(ruta, ApiLocationResponse.class);
            return response;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }


}
