# MulitiClientSpringMvcDemo

Controller层写法如下：<br>
@RequestMapping("/list")<br>
public ModelAndView list() {<br>
    SelfModelAndView modelAndView = new SelfModelAndView("list");<br>
    modelAndView.addJsonAndViewData("productList", productService.list());<br>
    return modelAndView;<br>
}<br>

SelfModelAndView作为ModelAndView的子类，需强制被使用。<br>
网页和App共用的数据，通过addJsonAndViewData设置。<br>

其余部分写法，和传统方式，几乎完全一致。<br>
