package controller;

import com.fasterxml.jackson.annotation.JsonView;
import exception.ProductNotFoundException;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import service.ProductService;
import util.ClientTypeUtil;
import util.JsonViewUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/6/17.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("productList", productService.list());
        return modelAndView;
    }

    @RequestMapping("/addInit")
    public ModelAndView addInit() {
        ModelAndView modelAndView = new ModelAndView("add");
        return modelAndView;
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(@RequestHeader HttpHeaders headers,
                                   Product product, HttpServletResponse response) {
        productService.add(product);
        if (ClientTypeUtil.isAppClient(headers)) {
            Map<String, Long> data = new HashMap<>();
            data.put("id", product.getId());
            JsonViewUtil.suc(response, "add suc", data);
            return null;
        } else {
            ModelAndView modelAndView = new ModelAndView("forward:list");
            return modelAndView;
        }
    }

    @RequestMapping("/detail")
    public ModelAndView detail(Long id,
                             @RequestHeader HttpHeaders headers,
                             HttpServletResponse response) {
        Product product = productService.get(id);
        if (ClientTypeUtil.isAppClient(headers)) {
            JsonViewUtil.suc(response, "find suc", product);
            return null;
        } else {
            ModelAndView modelAndView = new ModelAndView("detail");
            modelAndView.addObject("product", product);
            return modelAndView;
        }
    }

    @RequestMapping("/updateInit")
    public ModelAndView updateInit(Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        Product product = productService.get(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/updateProduct")
    public ModelAndView update(Product product,
                               @RequestHeader HttpHeaders headers,
                               HttpServletResponse response) {
        productService.update(product);
        if (ClientTypeUtil.isAppClient(headers)) {
            JsonViewUtil.suc(response, "update suc", null);
            return null;
        } else {
            ModelAndView modelAndView = new ModelAndView("forward:list");
            return modelAndView;
        }
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestHeader HttpHeaders headers,
                               Long id,
                               HttpServletResponse response) {
        productService.delete(id);
        if (ClientTypeUtil.isAppClient(headers)) {
            JsonViewUtil.suc(response, "delete suc", null);
            return null;
        } else {
            ModelAndView modelAndView = new ModelAndView("forward:list");
            return modelAndView;
        }
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="商品id不匹配")
    public void handleProductNotFound() {
    }

}
