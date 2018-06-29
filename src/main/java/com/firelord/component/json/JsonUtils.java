package com.firelord.component.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import lombok.val;

public class JsonUtils {
	// #region toObj

	public static <T> T toObj(String strJson, Class<T> oClazz) {
		val oJsonParser = new JsonParser();
		return oJsonParser.parse(strJson, oClazz);
	}

	// #endregion

	// #reigon toStr

	public static String toStr(Object oJsonObj) {
		JsonSerializer oJsonSerializer = new JsonSerializer();
		String strRes = oJsonSerializer.deep(true).serialize(oJsonObj);
		return strRes;
	}

	// #endregion

	// #region toMap

	public static Map<String, String> toMap(String strJsonObj) {
		Map<String, String> mapRes = new HashMap<String, String>();
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

	// #endregion
}
