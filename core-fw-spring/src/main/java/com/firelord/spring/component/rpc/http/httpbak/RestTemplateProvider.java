package com.firelord.spring.component.rpc.http.httpbak;

@Deprecated
//@Component
public class RestTemplateProvider {
//    //#region Fields
//
//    @Autowired
//    private ConfigRestTemplateVo configRestTemplateVo;
//
//    @Autowired
//    private RestTemplate restTemplate4Sys;
//
//    @Autowired
//    private RestTemplate restTemplate4Bu;
//
//    @Bean
//    public ConfigRestTemplateVo configRestTemplateVo() {
//        return new ConfigRestTemplateVo();
//    }
//
//    @Bean
//    public RestTemplate restTemplate4Sys() {
//        // 1.set timeout
//        HttpComponentsClientHttpRequestFactory oRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        oRequestFactory.setConnectionRequestTimeout(configRestTemplateVo.getHttpRestTimeout4ReqSys());
//        oRequestFactory.setConnectTimeout(configRestTemplateVo.getHttpRestTimeout4ConSys());
//        oRequestFactory.setReadTimeout(configRestTemplateVo.getHttpRestTimeout4ReadSys());
//        RestTemplate oRestTemplate = new RestTemplate(oRequestFactory);
//
//        // JacksonConverter
//        boolean bIsExists = false;
//        for (HttpMessageConverter<?> oConverter : oRestTemplate.getMessageConverters()) {
//            if (oConverter instanceof MappingJackson2HttpMessageConverter) {
//                bIsExists = true;
//                break;
//            }
//        }
//        if (!bIsExists) {
//            oRestTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        }
//
//        return oRestTemplate;
//    }
//
//    @Bean
//    public RestTemplate restTemplate4Bu() {
//        // 长连接保持30秒
//        PoolingHttpClientConnectionManager oPoolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(
//                30, TimeUnit.SECONDS);
//        // 总连接数
//        oPoolingHttpClientConnectionManager.setMaxTotal(1000);
//        // 同路由的并发数
//        oPoolingHttpClientConnectionManager.setDefaultMaxPerRoute(1000);
//
//        HttpClientBuilder oHttpClientBuilder = HttpClients.custom();
//        oHttpClientBuilder.setConnectionManager(oPoolingHttpClientConnectionManager);
//        // // 重试次数，默认是3次，没有开启
//        // oHttpClientBuilder.setRetryHandler(new
//        // DefaultHttpRequestRetryHandler(2, true));
//        // 保持长连接配置，需要在头添加Keep-Alive
//        oHttpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
//
//        // RequestConfig.Builder builder = RequestConfig.custom();
//        // builder.setConnectionRequestTimeout(200);
//        // builder.setConnectTimeout(5000);
//        // builder.setSocketTimeout(5000);
//        //
//        // RequestConfig requestConfig = builder.build();
//        // httpClientBuilder.setDefaultRequestConfig(requestConfig);
//
//        // List<Header> headers = new ArrayList<>();
//        // headers.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
//        // headers.add(new BasicHeader("Accept-Language", "zh-CN"));
//        // headers.add(new BasicHeader("Connection", "Keep-Alive"));
//        // oHttpClientBuilder.setDefaultHeaders(headers);
//
//        HttpClient oHttpClient = oHttpClientBuilder.build();
//        // httpClient连接配置，底层是配置RequestConfig
//
//        // 1.set timeout
//        HttpComponentsClientHttpRequestFactory oRequestFactory = new HttpComponentsClientHttpRequestFactory(
//                oHttpClient);
//        // 连接不够用的等待时间，不宜过长，必须设置，比如连接不够用时，时间过长将是灾难性的
//        oRequestFactory.setConnectionRequestTimeout(configRestTemplateVo.getHttpRestTimeout4ReqBu());
//        // 连接超时
//        oRequestFactory.setConnectTimeout(configRestTemplateVo.getHttpRestTimeout4ConBu());
//        // 数据读取超时时间，即SocketTimeout
//        oRequestFactory.setReadTimeout(configRestTemplateVo.getHttpRestTimeout4ReadBu());
//        // 缓冲请求数据，默认值是true。通过POST或者PUT大量发送数据时，建议将此属性更改为false，以免耗尽内存。
//        // oRequestFactory.setBufferRequestBody(false);
//        RestTemplate oRestTemplate = new RestTemplate(oRequestFactory);
//
//        // JacksonConverter
//        boolean bIsExists = false;
//        for (HttpMessageConverter<?> oConverter : oRestTemplate.getMessageConverters()) {
//            if (oConverter instanceof MappingJackson2HttpMessageConverter) {
//                bIsExists = true;
//                break;
//            }
//        }
//        if (!bIsExists) {
//            oRestTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        }
//
//        return oRestTemplate;
//    }
//
//    //#endregion
//
//    //#region post
//
//    public <T> T post4Sys(String strUrl, Object oParams, Class<T> oClazz) {
//        T oRes = post4SysSecure(strUrl, oParams, oClazz, "", "");
//        return oRes;
//    }
//
//    public <T> void post4SysAsync(final String strUrl, final Object oParams, final Class<T> oClazz) {
//        post4SysAsyncSecure(strUrl, oParams, oClazz, "", "");
//    }
//
//    public <T> T post4Bu(String strUrl, Object oParams, Class<T> oClazz) {
//        T oRes = post4BuSecure(strUrl, oParams, oClazz, "", "");
//        return oRes;
//    }
//
//    public <T> void post4BuAsync(final String strUrl, final Object oParams, final Class<T> oClazz) {
//        post4BuAsyncSecure(strUrl, oParams, oClazz, "", "");
//    }
//
//    public void post4BuDel(String strUrl) {
//        restTemplate4Bu.delete(strUrl);
//    }
//
//    //#endregion
//
//    //#region postSecure
//
//    public <T> T post4SysSecure(String strUrl, Object oParams, Class<T> oClazz, String strTokenKey,
//                                String strTokenAPI) {
//        MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
//        header.add("Content-Type", "application/json");
//        if (!StringUtils.isEmpty(strTokenKey)) {
//            header.add(strTokenKey, strTokenAPI);
//        }
//        HttpEntity<Object> oRequest = new HttpEntity<Object>(oParams, header);
//        T oRes = restTemplate4Sys.postForObject(strUrl, oRequest, oClazz);
//        return oRes;
//    }
//
//    public <T> void post4SysAsyncSecure(final String strUrl, final Object oParams, final Class<T> oClazz,
//                                        String strTokenKey, String strTokenAPI) {
//        ThreadPoolUtils.getProvider().submit4Sys(new Runnable() {
//            @Override
//            public void run() {
//                MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
//                header.add("Content-Type", "application/json");
//                if (!StringUtils.isEmpty(strTokenKey)) {
//                    header.add(strTokenKey, strTokenAPI);
//                }
//                HttpEntity<Object> oRequest = new HttpEntity<Object>(oParams, header);
//                restTemplate4Sys.postForObject(strUrl, oRequest, oClazz);
//            }
//        });
//    }
//
//    public <T> T post4BuSecure(String strUrl, Object oParams, Class<T> oClazz, String strTokenKey, String strTokenAPI) {
//        MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
//        header.add("Content-Type", "application/json");
//        if (!StringUtils.isEmpty(strTokenKey)) {
//            header.add(strTokenKey, strTokenAPI);
//        }
//        HttpEntity<Object> oRequest = new HttpEntity<Object>(oParams, header);
//        T oRes = restTemplate4Bu.postForObject(strUrl, oRequest, oClazz);
//        return oRes;
//    }
//
//    public <T> void post4BuAsyncSecure(final String strUrl, final Object oParams, final Class<T> oClazz,
//                                       String strTokenKey, String strTokenAPI) {
//        ThreadPoolUtils.getProvider().submit4Bu(new Runnable() {
//            @Override
//            public void run() {
//                MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
//                header.add("Content-Type", "application/json");
//                if (!StringUtils.isEmpty(strTokenKey)) {
//                    header.add(strTokenKey, strTokenAPI);
//                }
//                HttpEntity<Object> oRequest = new HttpEntity<Object>(oParams, header);
//                restTemplate4Bu.postForObject(strUrl, oRequest, oClazz);
//            }
//        });
//    }
//
//    //#endregion
//
//    //#region get
//
//    public <T> T get4Sys(String strUrl, Class<T> oRespClazz) {
//        return this.restTemplate4Sys.getForObject(strUrl, oRespClazz);
//    }
//
//    public String get4SysEx(String strUrl) {
//        String strRes = this.restTemplate4Sys.getForObject(strUrl, String.class);
//        return strRes;
//    }
//
//    //#endregion
}
