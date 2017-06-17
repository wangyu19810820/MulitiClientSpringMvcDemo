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
        ModelAndView modelAndView = new ModelAndView("list");
        ResultModel resultModel = new ResultModel(ResultModel.RESULT_STATUS_SUC,
                "suc", productService.list());
        modelAndView.addObject(ResultModel.RESULT_BEAN_NAME, resultModel);
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
        ModelAndView modelAndView = new ModelAndView("forward:list");
        ResultModel resultModel = new ResultModel(ResultModel.RESULT_STATUS_SUC, "add suc");
        modelAndView.addObject(ResultModel.RESULT_BEAN_NAME, resultModel);
        return modelAndView;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(Long id,
                             @RequestHeader HttpHeaders headers,
                             HttpServletResponse response) {
        Product product = productService.get(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        ResultModel resultModel = null;
        if (product != null) {
            resultModel = new ResultModel(ResultModel.RESULT_STATUS_SUC,
                    "find suc", product);
        } else {
            resultModel = new ResultModel(ResultModel.RESULT_STATUS_FAIL,
                    "not found");
        }
        modelAndView.addObject(ResultModel.RESULT_BEAN_NAME, resultModel);
        return modelAndView;
    }

    @RequestMapping("/updateInit")
    public ModelAndView updateInit(Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        Product product = productService.get(id);
        ResultModel resultModel = new ResultModel(ResultModel.RESULT_STATUS_SUC,
                "suc", product);
        modelAndView.addObject(ResultModel.RESULT_BEAN_NAME, resultModel);
        return modelAndView;
    }

    @RequestMapping("/updateProduct")
    public ModelAndView update(Product product,
                               @RequestHeader HttpHeaders headers,
                               HttpServletResponse response) {
        productService.update(product);
        ModelAndView modelAndView = new ModelAndView("forward:list");
        ResultModel resultModel = new ResultModel(ResultModel.RESULT_STATUS_SUC, "update suc");
        modelAndView.addObject(ResultModel.RESULT_BEAN_NAME, resultModel);
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestHeader HttpHeaders headers,
                               Long id,
                               HttpServletResponse response) {
        productService.delete(id);
        ModelAndView modelAndView = new ModelAndView("forward:list");
        ResultModel resultModel = new ResultModel(ResultModel.RESULT_STATUS_SUC, "delete suc");
        modelAndView.addObject(ResultModel.RESULT_BEAN_NAME, resultModel);
        return modelAndView;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="商品id不匹配")
    public void handleProductNotFound() {
    }

}
