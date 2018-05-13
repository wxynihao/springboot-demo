package me.rainking.controller;

import me.rainking.properties.ConfigsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Value("${configItem}")
    private String configItem;

    @Autowired
    private ConfigsProperties configsProperties;

    /**
     * @return
     */
    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    @ResponseBody
    public String say() {
        return configsProperties.getName();
    }

    @RequestMapping({"/index","/"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getPath(@PathVariable("id") Integer id) {
        return "id: " + id;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getPara(@RequestParam("id") Integer id) {
        return "id: " + id;
    }

    @RequestMapping(value = "/getdefault", method = RequestMethod.GET)
    @ResponseBody
    public String getDefault(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        return "id: " + id;
    }

}
