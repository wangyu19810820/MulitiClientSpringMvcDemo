package controller;

import exception.ProductNotFoundException;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;
import util.ResultModel;
import util.SelfModelAndView;
import static util.ResultModel.ResultStatus;

import javax.servlet.http.HttpServletResponse;

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
        SelfModelAndView modelAndView = new SelfModelAndView("list");
        modelAndView.addJsonAndViewData("productList", productService.list());
        return modelAndView;
    }

    @RequestMapping("/addInit")
    public ModelAndView addInit() {
        SelfModelAndView modelAndView = new SelfModelAndView("add");
        return modelAndView;
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(Product product) {
        productService.add(product);
        SelfModelAndView modelAndView = new SelfModelAndView("forward:list");
        modelAndView.setDesc("add suc");
        return modelAndView;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(Long id) {
        Product product = productService.get(id);
        SelfModelAndView modelAndView = new SelfModelAndView("detail");
        ResultModel resultModel = null;
        if (product != null) {
            modelAndView.setStatusAndDesc(ResultStatus.RESULT_STATUS_SUC, "find suc");
            modelAndView.addJsonAndViewData("product", product);
        } else {
            modelAndView.setStatusAndDesc(ResultStatus.RESULT_STATUS_FAIL, "not found");
        }
        return modelAndView;
    }

    @RequestMapping("/updateInit")
    public ModelAndView updateInit(Long id) {
        SelfModelAndView modelAndView = new SelfModelAndView("update");
        Product product = productService.get(id);
        modelAndView.addJsonAndViewData("product", product);
        return modelAndView;
    }

    @RequestMapping("/updateProduct")
    public ModelAndView update(Product product) {
        productService.update(product);
        SelfModelAndView modelAndView = new SelfModelAndView("forward:list");
        modelAndView.setDesc("update suc");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(Long id) {
        productService.delete(id);
        SelfModelAndView modelAndView = new SelfModelAndView("forward:list");
        modelAndView.setDesc("delete suc");
        return modelAndView;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="商品id不匹配")
    public void handleProductNotFound() {
    }

}
