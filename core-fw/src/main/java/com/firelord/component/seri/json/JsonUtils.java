package com.firelord.component.seri.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JsonUtils
 */
public class JsonUtils {
    //#region Const

    private static String SPACE = "   ";

    //#endregion

    //#region toObj

    /**
     * json to object
     *
     * @param strJson json string
     * @param oClazz  deserialize object type
     * @param <T>     deserialize object type
     * @return object
     */
    public static <T> T toObj(String strJson, Class<T> oClazz) {
        JsonParser oJsonParser = new JsonParser();
        return oJsonParser.parse(strJson, oClazz);
    }

    //#endregion

    //#region toStr

    /**
     * Json object to string
     *
     * @param oJsonObj Json object
     * @return string
     */
    public static String toStr(Object oJsonObj) {
        JsonSerializer oJsonSerializer = new JsonSerializer();
        String strRes = oJsonSerializer.deep(true).serialize(oJsonObj);
        return strRes;
    }

    //#endregion

    //#region toMap

    /**
     * json string to map
     *
     * @param strJsonObj json string
     * @return map
     */
    public static Map<String, String> toMap(String strJsonObj) {
        Map<String, String> mapRes = new HashMap<>();

        ObjectMapper oMapper = new ObjectMapper();
        try {
            mapRes = oMapper.readValue(strJsonObj, new TypeReference<HashMap<String, String>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapRes;
    }

    //#endregion

    //#region format

    /**
     * format json string
     *
     * @param strJson json string
     * @return format json string
     */
    public static String formatJson(String strJson) {
        StringBuffer strRes = new StringBuffer();

        int iLength = strJson.length();
        int iNum = 0;
        char cKey;
        for (int i = 0; i < iLength; i++) {
            cKey = strJson.charAt(i);
            //#region if arrayStart or objectStart
            if ((cKey == '[') || (cKey == '{')) {
                //if has ':' before arrayStart or objectStart
                if ((i - 1 > 0) && (strJson.charAt(i - 1) == ':')) {
                    strRes.append('\n');
                    strRes.append(indent(iNum));
                }

                //cKey
                strRes.append(cKey);

                //\n
                strRes.append('\n');

                //indent
                iNum++;
                strRes.append(indent(iNum));

                //continue
                continue;
            }
            //#endregion
            //#region if arrayEnd or objectEnd
            if ((cKey == ']') || (cKey == '}')) {
                //\n
                strRes.append('\n');

                //indent
                iNum--;
                strRes.append(indent(iNum));

                //cKey
                strRes.append(cKey);

                //if has "," after cKey
                if (((i + 1) < iLength) && (strJson.charAt(i + 1) != ',')) {
                    strRes.append('\n');
                }

                //continue
                continue;
            }
            //#endregion
            //#region if ,
            if ((cKey == ',')) {
                strRes.append(cKey);
                strRes.append('\n');
                strRes.append(indent(iNum));
                continue;
            }
            //#endregion
            strRes.append(cKey);
        }

        return strRes.toString();
    }

    private static String indent(int iNum) {
        StringBuffer strRes = new StringBuffer();
        for (int i = 0; i < iNum; i++) {
            strRes.append(SPACE);
        }
        return strRes.toString();
    }

    //#endregion
}
