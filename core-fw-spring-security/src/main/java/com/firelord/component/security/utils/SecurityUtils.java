package com.firelord.component.security.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SecurityUtils
 */
public class SecurityUtils {
    //#region getCurUser

    /**
     * get current login user identify
     *
     * @return current login user identify
     */
    public static String getCurUser() {
        Authentication oAuthentication = SecurityContextHolder.getContext().getAuthentication();
        return oAuthentication.getName();
    }

    //#endregion

    //#region getCurUserRoleLst

    /**
     * get current login user role list
     *
     * @return current login user role list
     */
    public static List<String> getCurUserRoleLst() {
        List<String> lstRes = new ArrayList<>();

        //get cur user
        Authentication oAuthentication = SecurityContextHolder.getContext().getAuthentication();

        //get role list
        Collection<? extends GrantedAuthority> lstRoles = oAuthentication.getAuthorities();
        for (GrantedAuthority o : lstRoles) {
            String strRoleName = o.getAuthority();
            lstRes.add(strRoleName);
        }

        return lstRes;
    }

    //#endregion
}
