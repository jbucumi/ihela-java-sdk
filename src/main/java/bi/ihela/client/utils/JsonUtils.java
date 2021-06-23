/**
 * 
 */
package bi.ihela.client.utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author jeanclaude.bucumi jeanclaude.bucumi@outlook.com
 */
public class JsonUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T toObject(String json, Class<T> objectType) throws Exception {
		return toObject(json, objectType, false);

	}

	public static <T> String toJson(T object) throws Exception {
		return toJson(object, false);
	}

	public static <T> T toObject(String json, Class<T> objectType, Boolean urv) throws Exception {
		if (urv)
			objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		CompletableFuture<T> cf = CompletableFuture.supplyAsync(() -> {
			try {
				return objectMapper.readValue(json, objectType);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		});
		return cf.get();
	}

	public static <T> String toJson(T object, Boolean prettyPrint) throws Exception {
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		if (prettyPrint)
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			try {
				return objectMapper.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return null;
		});

		return cf.get();
	}

}
