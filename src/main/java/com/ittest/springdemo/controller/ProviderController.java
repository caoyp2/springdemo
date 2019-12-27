package com.ittest.springdemo.controller;

import com.ittest.springdemo.dao.ProviderDao;
import com.ittest.springdemo.entities.Provider;
import com.ittest.springdemo.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class ProviderController {
    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProviderService providerService;

    @GetMapping("/providers")
    public String list(Map<String,Object> map,
                       @RequestParam(value = "providername",required = false) String providername){
        logger.info("providers-------" + providername);
        Collection<Provider> providers =  providerService.getAll(providername);
                map.put("providers",providers);

        return "provider/list";
    }

    /**
     * @PathVariable("pid") Integer pid 获取请求的中的参数并映射到变量pid
     * @param map
     * @param pid
     * @return
     */
    @GetMapping("/provider/{pid}")
    public String getProvider(@PathVariable("pid") Integer pid ,
                              @RequestParam(value = "type",defaultValue = "view") String type,
                              Map<String,Object> map){
        logger.info("type-----------" + type);
        Provider provider = providerService.getProviderByPid(pid);
        map.put("provider",provider);

        return "provider/" + type;
    }

    /**
     * 修改供应商
     */
    @PutMapping("/provider")
    public String putProvider(Provider provider){
        providerService.updateProvider(provider);
        return "redirect:/providers";
    }

    //跳转到添加供应商
    @GetMapping("/provider")
    public String toAdd(){
        return "provider/add";
    }

    //添加供应商
    @PostMapping("/provider")
    public String addProvider(Provider provider){
        providerService.addProvider(provider);
        return "redirect:/providers";
    }

    //删除供应商
    @DeleteMapping("/provider/{pid}")
    public String deleteProvider(@PathVariable("pid") Integer pid){
        logger.info("pid=" + pid);
        providerService.deleteProviderBypid(pid);
        return "redirect:/providers";
    }
}


