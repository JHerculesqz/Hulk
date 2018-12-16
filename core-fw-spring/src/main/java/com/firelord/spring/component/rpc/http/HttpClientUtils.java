package com.firelord.spring.component.rpc.http;

import com.firelord.spring.component.rpc.http.vo.HttpClientInVo;
import com.firelord.spring.component.rpc.http.vo.HttpClientOutVo;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClientUtils
 */
public class HttpClientUtils {
    //#region Fields

    private static HttpClientUtils m_oInstance;

    private CloseableHttpClient httpclient = HttpClients.createDefault();

    //#endregion

    //#region Construction

    private HttpClientUtils() {
    }

    /**
     * get instance
     *
     * @return HttpClientUtils object
     */
    public static HttpClientUtils getInstance() {
        if (null == m_oInstance) {
            m_oInstance = new HttpClientUtils();
        }
        return m_oInstance;
    }

    //#endregion

    //#region get

    /**
     * execute get
     *
     * @param oInVo HttpClientInVo
     * @return HttpClientOutVo
     */
    public HttpClientOutVo get(HttpClientInVo oInVo) {
        HttpClientOutVo oOutVo = new HttpClientOutVo();

        try {
            //URI
            URI oURI = new URIBuilder()
                    .setScheme("http")
                    .setHost(oInVo.getHost())
                    .setPath(oInVo.getUrl())
                    .setParameters(this.genNVPLst(oInVo.getParams()))
                    .build();
            HttpGet oHttpGet = new HttpGet(oURI);

            //Execute
            CloseableHttpResponse oResponse = this.httpclient.execute(oHttpGet);

            //Output
            oOutVo.setStatusCode(oResponse.getStatusLine().getStatusCode());
            oOutVo.setReasonPhrase(oResponse.getStatusLine().getReasonPhrase());
            HttpEntity oHttpEntity = oResponse.getEntity();
            oOutVo.setContent(EntityUtils.toString(oHttpEntity));
            EntityUtils.consume(oHttpEntity);

            //Destroy
            oResponse.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return oOutVo;
    }

    private List<NameValuePair> genNVPLst(Map<String, String> mapParams) {
        List<NameValuePair> lstParams = new ArrayList<>();

        if (null != mapParams) {
            for (String strKey : mapParams.keySet()) {
                String oValue = mapParams.get(strKey);
                NameValuePair oNVP = new BasicNameValuePair(strKey, oValue);
                lstParams.add(oNVP);
            }
        }

        return lstParams;
    }

    public String get(String strUrl) {
        String strRes = "";

        try {
            //Url
            HttpGet oHttpGet = new HttpGet(strUrl);

            //Execute
            CloseableHttpResponse oResponse = this.httpclient.execute(oHttpGet);

            //Output
            HttpEntity oHttpEntity = oResponse.getEntity();
            strRes = EntityUtils.toString(oHttpEntity);
            EntityUtils.consume(oHttpEntity);

            //Destroy
            oResponse.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strRes;
    }

    //#endregion

    //#region post

    /**
     * execute post json
     *
     * @param oInVo HttpClientInVo
     * @return HttpClientOutVo
     */
    public HttpClientOutVo postJson(HttpClientInVo oInVo) {
        HttpClientOutVo oOutVo = new HttpClientOutVo();

        try {
            //URI
            URI oURI = new URIBuilder()
                    .setScheme("http")
                    .setHost(oInVo.getHost())
                    .setPath(oInVo.getUrl())
                    .setParameters(this.genNVPLst(oInVo.getParams()))
                    .build();
            HttpPost oHttpPost = new HttpPost(oURI);

            //Input
            ContentType oContentType = ContentType.create("application/json",
                    Consts.UTF_8);
            StringEntity oEntity = new StringEntity(oInVo.getInput(), oContentType);
            oEntity.setChunked(true);
            oHttpPost.setEntity(oEntity);

            //Execute
            CloseableHttpResponse oResponse = this.httpclient.execute(oHttpPost);

            //Output
            oOutVo.setStatusCode(oResponse.getStatusLine().getStatusCode());
            oOutVo.setReasonPhrase(oResponse.getStatusLine().getReasonPhrase());
            HttpEntity oHttpEntity = oResponse.getEntity();
            oOutVo.setContent(EntityUtils.toString(oHttpEntity));
            EntityUtils.consume(oHttpEntity);

            //Destroy
            oResponse.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return oOutVo;
    }

    /**
     * execute post form
     *
     * @param oInVo HttpClientInVo
     * @return HttpClientOutVo
     */
    public HttpClientOutVo postForm(HttpClientInVo oInVo) {
        HttpClientOutVo oOutVo = new HttpClientOutVo();

        try {
            //URI
            URI oURI = new URIBuilder()
                    .setScheme("http")
                    .setHost(oInVo.getHost())
                    .setPath(oInVo.getUrl())
                    .setParameters(this.genNVPLst(oInVo.getParams()))
                    .build();
            HttpPost oHttpPost = new HttpPost(oURI);

            //Input
            UrlEncodedFormEntity oEntity = new UrlEncodedFormEntity(
                    this.genNVPLst(oInVo.getFormData()), Consts.UTF_8);
            oHttpPost.setEntity(oEntity);

            //Execute
            CloseableHttpResponse oResponse = this.httpclient.execute(oHttpPost);

            //Output
            oOutVo.setStatusCode(oResponse.getStatusLine().getStatusCode());
            oOutVo.setReasonPhrase(oResponse.getStatusLine().getReasonPhrase());
            HttpEntity oHttpEntity = oResponse.getEntity();
            oOutVo.setContent(EntityUtils.toString(oHttpEntity));
            EntityUtils.consume(oHttpEntity);

            //Destroy
            oResponse.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return oOutVo;
    }

    //#endregion

    //#region download

    /**
     * download
     *
     * @param strFilePath file path
     * @param oResponse   HttpServletResponse
     */
    public void download(String strFilePath, HttpServletResponse oResponse) {
        File oFile = new File(strFilePath);
        if (oFile.exists()) {
            try {
                oResponse.setContentType("application/force-download");
                oResponse.setHeader("Content-Disposition", "attachment;fileName=" +
                        oFile.getName());
                // get your file as InputStream
                InputStream is = new FileInputStream(oFile);
                // copy it to response's OutputStream
                org.apache.commons.io.IOUtils.copy(is, oResponse.getOutputStream());
                oResponse.flushBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //#endregion
}
