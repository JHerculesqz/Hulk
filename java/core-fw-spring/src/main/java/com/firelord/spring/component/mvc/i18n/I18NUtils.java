package com.firelord.spring.component.mvc.i18n;

import com.firelord.spring.component.mvc.cookie.CookieUtilsEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * I18NUtils
 */
@Component
public class I18NUtils {
    //#region Const

    private static final String KEY_LANG = "lang";

    //#endregion

    //#region Fields

    @Autowired
    private MessageSource messageSource;

    //#endregion

    //#region getMessage

    /**
     * get message by locale
     *
     * @param strKey message key
     * @return message by locale
     */
    public String getMessage(String strKey) {
        String strKeyLang = CookieUtilsEx.getCookie(KEY_LANG);
        String[] arrKeyLang = strKeyLang.split("_");
        LocaleContextHolder.setLocale(new Locale(arrKeyLang[0], arrKeyLang[1]));
        Locale oLocale = LocaleContextHolder.getLocale();
        String strRes = messageSource.getMessage(strKey, null, oLocale);
        return strRes;
    }

    //#endregion
}