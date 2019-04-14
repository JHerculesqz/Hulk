package com.firelord.component.misc.weather;

import com.firelord.component.misc.weather.mo.GetWeatherOutVo;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class WeatherUtils {
    //#region Const

    private static final String SERVICES_HOST = "www.webxml.com.cn";
    private static final String WEATHER_SERVICES_URL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/";
    private static final String WEATHER_QUERY_URL = WEATHER_SERVICES_URL + "getWeather?theUserID=&theCityCode=";

    //#endregion

    //#region getWeathers

    public static GetWeatherOutVo getWeathers(int iCityCode) {
        //generate lstRes
        List<String> lstRes = new ArrayList<>();
        try {
            //gen db
            DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
            documentBF.setNamespaceAware(true);
            DocumentBuilder db = documentBF.newDocumentBuilder();

            //post
            URL urlObj = new URL(WEATHER_QUERY_URL + iCityCode);
            URLConnection urlConn = urlObj.openConnection();
            urlConn.setRequestProperty("Host", SERVICES_HOST);
            urlConn.connect();

            //parse xml
            InputStream inputStream = urlConn.getInputStream();
            Document document = db.parse(inputStream);
            NodeList nl = document.getElementsByTagName("string");
            int len = nl.getLength();
            for (int i = 0; i < len; i++) {
                Node n = nl.item(i);
                String weather = n.getFirstChild().getNodeValue();
                System.out.println(weather);
                lstRes.add(weather);
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //to OutVo
        GetWeatherOutVo oOutVo = new GetWeatherOutVo();
        for (int i = 0; i < lstRes.size(); i++) {
            String strRes = lstRes.get(i);

            //date
            if (3 == i) {
                oOutVo.setDate(strRes);
            }
            //template/wind/humidity
            else if (4 == i) {
                String[] arrSubRes = strRes.split("；");
                for (int j = 0; j < arrSubRes.length; j++) {
                    String strSubRes = arrSubRes[j];
                    if (0 == j) {
                        String strTemperature = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        strTemperature = strTemperature.replace("℃", "");
                        oOutVo.setTemperature(strTemperature);
                    } else if (1 == j) {
                        String strWind = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        oOutVo.setWind(strWind);
                    } else if (2 == j) {
                        String strHumidity = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        oOutVo.setHumidity(strHumidity);
                    }
                }
            }
            //UltravioletRay/AirQuality
            else if (5 == i) {
                String[] arrSubRes = strRes.split("。");
                for (int j = 0; j < arrSubRes.length; j++) {
                    String strSubRes = arrSubRes[j];
                    if (0 == j) {
                        String strUltravioletRay = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        oOutVo.setUltravioletRay(strUltravioletRay);
                    } else if (1 == j) {
                        String strAirQuality = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        oOutVo.setAirQuality(strAirQuality);
                    }
                }
            }
            //GlycemicIndex/AirQuality/DressingIndex/WashingIndex/AirPollutionIndex
            else if (6 == i) {
                String[] arrSubRes = strRes.split("\n");
                for (int j = 0; j < arrSubRes.length; j++) {
                    String strSubRes = arrSubRes[j];
                    if (1 == j) {
                        String strGlycemicIndex = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        oOutVo.setGlycemicIndex(strGlycemicIndex);
                    } else if (2 == j) {
                        String strDressingIndex = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        oOutVo.setDressingIndex(strDressingIndex);
                    } else if (3 == j) {
                        String strWashingIndex = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        oOutVo.setWashingIndex(strWashingIndex);
                    } else if (4 == j) {
                        String strAirPollutionIndex = strSubRes.substring(strSubRes.lastIndexOf("：") + 1);
                        oOutVo.setAirPollutionIndex(strAirPollutionIndex);
                    }
                }
            }
            //WeatherOverview
            else if (7 == i) {
                String[] arrSubRes = strRes.split(" ");
                for (int j = 0; j < arrSubRes.length; j++) {
                    String strSubRes = arrSubRes[j];
                    if (1 == j) {
                        oOutVo.setWeatherOverview(strSubRes);
                    }
                }
            }
        }

        return oOutVo;
    }

    //#endregion
}