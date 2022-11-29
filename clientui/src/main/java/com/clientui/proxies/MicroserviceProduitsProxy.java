package com.clientui.proxies;

import com.clientui.beans.ProductBean;
import com.clientui.configuration.LoadBalancerConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.List;


@FeignClient(name = "API-Gateway", url = "http://localhost:9999")
@LoadBalancerClient(name = "microservice-produits", configuration= LoadBalancerConfiguration.class)

public interface MicroserviceProduitsProxy {

    @GetMapping(value = "/MICROSERVICE-PRODUITS/Produits")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "/MICROSERVICE-PRODUITS/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);

}
