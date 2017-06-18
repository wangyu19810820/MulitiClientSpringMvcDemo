# MulitiClientSpringMvcDemo

Controller层写法如下：
@RequestMapping("/list")
public ModelAndView list() {
    SelfModelAndView modelAndView = new SelfModelAndView("list");
    modelAndView.addJsonAndViewData("productList", productService.list());
    return modelAndView;
}

SelfModelAndView作为ModelAndView的子类，需强制被使用。
网页和App共用的数据，通过addJsonAndViewData设置。

其余部分写法，和传统方式，几乎完全一致。
