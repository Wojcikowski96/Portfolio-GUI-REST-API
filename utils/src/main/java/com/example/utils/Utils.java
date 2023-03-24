package com.example.utils;

import java.lang.reflect.Field;
import java.util.Hashtable;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Utils {

  public static <E> E updater(E oldEntity, E newEntity) {

    Field[] newEntityFields = newEntity.getClass().getDeclaredFields();
    Hashtable newHT = fieldsToHT(newEntityFields, newEntity);

    Class oldEntityClass = oldEntity.getClass();
    Field[] oldEntityFields = oldEntityClass.getDeclaredFields();

    for (Field field : oldEntityFields){
      field.setAccessible(true);
      Object o = newHT.get(field.getName());
      if (o != null){
        try {
          Field f = oldEntityClass.getDeclaredField(field.getName());
          f.setAccessible(true);
          log.info("setting " + f.getName());
          f.set(oldEntity, o);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        } catch (NoSuchFieldException e) {
          e.printStackTrace();
        }
      }

    }

    return oldEntity;
  }



  private static Hashtable<String, Object> fieldsToHT(Field[] fields, Object obj){
    Hashtable<String,Object> hashtable = new Hashtable<>();
    for (Field field: fields){
      field.setAccessible(true);
      try {
        Object retrievedObject = field.get(obj);
        if (retrievedObject != null){
          log.info("scanning " + field.getName());
          hashtable.put(field.getName(), field.get(obj));
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return hashtable;
  }

  public static String generateImageUrl(Long entryID, String imageName){

    String url = null;

    if(imageName == null){
      url = "http://localhost:8080/images/image?entryId="+entryID;
    }else{
      url = "http://localhost:8080/images/image?entryId="+entryID+"?imageName="+imageName;
    }

    return url;
  }
}