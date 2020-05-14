package com.imooc.controller;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.StoreTable;
import com.imooc.exception.SellException;
import com.imooc.form.CategoryForm;
import com.imooc.form.StoreTableForm;
import com.imooc.service.StoreTableService;
import com.imooc.utils.ZxingTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 门店桌位
 * Created by skl
 */
@Controller
@RequestMapping("/seller/storetable")
@Slf4j
public class StoreTableController {

    @Autowired
    private StoreTableService storeTableService;

    /**
     * 列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map,Long storeId) {
        List<StoreTable> storeTableList = storeTableService.findByStoreId(storeId);
        map.put("storeTableList", storeTableList);
        map.put("storeId", storeId);
        return new ModelAndView("storetable/list", map);
    }

    /**
     * 展示
     * @param tableId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "tableId", required = false) Integer tableId,
                              Map<String, Object> map,Long storeId) {
        if (tableId != null) {
            StoreTable storeTable = storeTableService.findOne(tableId);
            map.put("storeTable", storeTable);
        }
        map.put("storeId", storeId);
        return new ModelAndView("storetable/index", map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid StoreTableForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map,Long storeId) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/storetable/index?storeId="+storeId);
            return new ModelAndView("common/error", map);
        }

        StoreTable storeTable = new StoreTable();
        storeTable.setStoreId(storeId);
        try {
            if (form.getTableId() != null) {
                storeTable = storeTableService.findOne(form.getTableId());
            }
            BeanUtils.copyProperties(form, storeTable);
            storeTableService.save(storeTable);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/storetable/list?storeId="+storeId);
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/storetable/list?storeId="+storeId);
        return new ModelAndView("common/success", map);
    }


    /**
     * 展示
     * @param tableId
     * @param map
     * @return
     */
    @GetMapping("/qrCode")
    public void qrCode(@RequestParam(value = "tableId", required = false) Integer tableId,
                       Map<String, Object> map, Long storeId, HttpServletRequest request, HttpServletResponse response)throws IOException {
        try {
            BufferedImage qrImage = ZxingTool.encodeQRcode(tableId + "," + storeId, 1000, 1000);
            //设置请求头
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="  + new String(("桌号" + ".png").getBytes(), "iso-8859-1"));
            OutputStream outputStream = response.getOutputStream();
            //MatrixToImageWriter.writeToStream(qrImage., "png", outputStream);
            outputStream.write(ZxingTool.writeImageByte(qrImage));
            outputStream.flush();
        }catch (Exception e){
            log.error("下载二维码错误"+e);
            e.printStackTrace();
        }
    }
}
