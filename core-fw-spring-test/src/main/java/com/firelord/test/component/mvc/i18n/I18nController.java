package com.firelord.test.component.mvc.i18n;

import com.firelord.spring.component.mvc.i18n.I18NUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc/i18n")
public class I18nController {
    //#region Fields

    @Autowired
    private I18NUtils i18NUtils;

    //#endregion

    //#region test1

    /**
     * test1
     */
    @RequestMapping("/test1")
    @ResponseBody
    @SuppressWarnings("unused")
    public void test1() {
        String msg = this.i18NUtils.getMessage("msg");
    }

    //#endregion
}
