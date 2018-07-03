package com.firelord.component.seri;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

public class KryoUtilsEx {
	// #region toBytes

	public static <T extends Serializable> byte[] toBytes(T oObj) {
		byte[] arrRes = null;

		try {
			Kryo oKryo = new Kryo();
			oKryo.register(oObj.getClass(), new JavaSerializer());

			ByteArrayOutputStream oByteArrayOutputStream = new ByteArrayOutputStream();
			Output oOutput = new Output(oByteArrayOutputStream);
			oKryo.writeClassAndObject(oOutput, oObj);
			oOutput.flush();
			oOutput.close();
			arrRes = oByteArrayOutputStream.toByteArray();

			oByteArrayOutputStream.flush();
			oByteArrayOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arrRes;
	}

	// #endregion

	// #region toObj

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T toObj(byte[] arrContent, Class<T> oClazz) {
		Kryo oKryo = new Kryo();
		oKryo.register(oClazz, new JavaSerializer());

		ByteArrayInputStream b = new ByteArrayInputStream(arrContent);
		Input oInput = new Input(b);
		return (T) oKryo.readClassAndObject(oInput);
	}

	// #endregion
}
