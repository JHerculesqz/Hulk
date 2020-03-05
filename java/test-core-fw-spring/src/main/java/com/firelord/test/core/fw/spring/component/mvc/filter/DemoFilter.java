package com.firelord.test.core.fw.spring.component.mvc.filter;

import com.firelord.spring.component.mvc.filter.HulkFilter;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * DemoFilter(老的鉴权机制，仅供参考)
 */
@WebFilter(filterName = "DemoFilter", urlPatterns = "/*")
@Log4j2
public class DemoFilter extends HulkFilter implements Filter {
    //#region Const

    private static final String LOG_INIT = "[DemoFilter.init] ";
    private static final String LOG_DESTROY = "[DemoFilter.destroy]";

    //#endregion

    //#region init

    @Override
    public void init(FilterConfig filterConfig) {
        log.info(LOG_INIT + "start...");
//
//        //#region m_lstExcludeUrl
//
//        //init
//        this.getExcludeFileLst().addAll(Arrays.asList("/", "/initIns"));
//
//        //sbi
//        this.getExcludeFileLst().addAll(Arrays.asList("/updateBasicInfoByDevId",
//                "/upsertWarnByDevId", "/clearAllWarnByDevId",
//                "/updateStatusByDevId", "/updateOnfflineStatusByTimer",
//                "/reportUsage4DayByTimer", "/reportUsage4DayByTimerTest",
//                "/updateCmdArg4Read", "/updateCmdArg4Write"));
//
//        //user
//        this.getExcludeFileLst().addAll(Arrays.asList("/login", "/isLogin", "/logout"));
//
//        //devMgr
//        this.getExcludeFileLst().addAll(Arrays.asList("/initDevByDevIdEx", "/getCompanyInfo"));
//
//        //#endregion
//
        log.info(LOG_INIT + "end...");
    }

    //#endregion

    //#region doFilter

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        //0.trans
//        HttpServletRequest oRequest = (HttpServletRequest) request;
//        HttpServletResponse oResponse = (HttpServletResponse) response;
//        String strUrl = oRequest.getRequestURI();
//
//        //1.如果是不过滤的，则直接放走
//        if (this.getExcludeUrlLst().contains(strUrl)) {
//            chain.doFilter(request, response);
//            return;
//        }
//        for (String strSuffix : this.getExcludeFileLst()) {
//            if (strUrl.endsWith(strSuffix)) {
//                chain.doFilter(request, response);
//                return;
//            }
//        }
//
//        //在session中寻找strSessionId，获得bIsExpire
//        String strSessionId = oRequest.getSession().getId();
//        LoginOutVo oLoginOutVo = (LoginOutVo) oRequest.getSession().getAttribute(
//                strSessionId);
//        //如果oExpireTime不存在，则返回错误
//        if (null == oLoginOutVo) {
//            oResponse.getWriter().append("unathorize");
//            return;
//        }
//        String strTime = DateUtilsEx._initJDateTime(DateUtilsEx.TIMEZONE_0,
//                oLoginOutVo.getExpireTime()).toString();
//        boolean bIsExpire = DateUtilsEx.isExpire(strTime, DateUtilsEx.TIMEZONE_0);
//
//        //3.如果bIsExpire，则返回错误
//        if (bIsExpire) {
//            oRequest.getSession().removeAttribute(strSessionId);
//            oResponse.getWriter().append("unathorize");
//        }
//        //3.否则，则放过去
//        else {
//            chain.doFilter(request, response);
//        }
    }

    //#endregion

    //#region destroy

    @Override
    public void destroy() {
        log.info(LOG_DESTROY + "start...");
        log.info(LOG_DESTROY + "end...");
    }

    //#endregion
}
