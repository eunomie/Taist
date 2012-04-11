/*
 * Copyright (c) 2012, Business Geografic. All rights reserved. Code licensed under a proprietary
 * license.
 */
package taist;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.gson.Gson;
import com.google.inject.Singleton;

/**
 * A Message body writer to write Json using GSon
 * 
 * @author Dev Team
 */
@Provider
@Produces({MediaType.APPLICATION_JSON, "text/json"})
@Singleton
public class GsonBodyWriter implements MessageBodyWriter<Object> {

  private final LoadingCache<Integer, byte[]> cache;

  /**
   * Instantiate a new GsonMessageBodyWriter, initialize a cache of jsonObjects
   */
  public GsonBodyWriter() {
    cache =
        CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(20, TimeUnit.SECONDS)
            .build(new CacheLoader<Integer, byte[]>() {
              @Override
              public byte[] load(Integer key) throws Exception {
                return new byte[0];
              }
            });
  }

  private static boolean isJsonType(MediaType mediaType) {
    if (mediaType != null) {
      String subtype = mediaType.getSubtype();
      return "json".equalsIgnoreCase(subtype) || subtype.endsWith("+json");
    }

    return true;
  }

  @Override
  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return isJsonType(mediaType);
  }

  @Override
  public long getSize(Object t, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    byte[] result = getJsonBytes(t, type);
    if (result == null) {
      return -1;
    }
    return result.length;
  }

  private byte[] getJsonBytes(Object t, Class<?> type) {
    byte[] result = null;
    try {
      result = cache.get(t.hashCode());
    } catch (ExecutionException exception) {
      return null;
    }
    if (result.length == 0) {
      result = new Gson().toJson(t, type).getBytes();
      cache.put(t.hashCode(), result);
    }
    return result;
  }

  @Override
  public void writeTo(Object t, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
      throws IOException, WebApplicationException {
    byte[] result = getJsonBytes(t, type);
    if (result != null) {
      entityStream.write(result);
    }
    entityStream.flush();
  }

}
