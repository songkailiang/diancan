package com.imooc.controller;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dataobject.Store;
import com.imooc.exception.SellException;
import com.imooc.form.CategoryForm;
import com.imooc.form.StoreForm;
import com.imooc.service.StoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 门店相关
 * Created by skl
 */
@Controller
@RequestMapping("/seller/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * 门店列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map,@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<Store> storeList = storeService.findAll(request);
        map.put("storePageList", storeList);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("store/list", map);
    }

    /**
     * 展示
     * @param storeId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "storeId", required = false) Long storeId,
                              Map<String, Object> map) {
        if (storeId != null) {
            Store store = storeService.findOne(storeId);
            map.put("store", store);
        }

        return new ModelAndView("store/index", map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid StoreForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/store/index");
            return new ModelAndView("common/error", map);
        }

        Store store = new Store();
        try {
            if (form.getStoreId() != null) {
                store = storeService.findOne(form.getStoreId());
            }
            BeanUtils.copyProperties(form, store);
            storeService.save(store);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/store/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/store/list");
        return new ModelAndView("common/success", map);
    }


    /**
     * 删除
     * @param storeId
     * @param map
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "storeId", required = true) Long storeId,
                              Map<String, Object> map) {
        if (storeId != null) {
            storeService.delete(storeId);
        }
        map.put("url", "/sell/seller/store/list");
        return new ModelAndView("common/success", map);
    }
}
