package cn.cupid.surveypark.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class DataUtils {

	 public static Serializable copySrc2Traget(Serializable src){
		 try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(src);
			
			oos.close();
			bos.close();
			
			byte[] coy = bos.toByteArray();
			
			ByteArrayInputStream bis = new ByteArrayInputStream(coy);
			ObjectInputStream ois = new ObjectInputStream(bis);
			Serializable serializable = (Serializable)ois.readObject();

			ois.close();
			bis.close();
			
			return serializable;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 return null;
	 }

	 public static String arr2Str(String[] arr){
		 String value = "";
		 if(!DataUtils.isNull(arr)){
			 for(String str : arr){
				 value = value + str + ",";
			 }
			 return value.substring(0, value.length()-1);
		 }
		 return null;
	 }

	public static boolean contains(String[] oldValue, String value) {
		if(!DataUtils.isNull(oldValue)){
			for(String s : oldValue){
				if(s.equals(value)){
					return true;
				}
			}
		}
		return false;
	}

  private static String str2Lower(String clazzName) {
		String lower = clazzName.substring(0, 1).toLowerCase();
		clazzName = clazzName.replaceFirst(clazzName.substring(0, 1), lower);
		return clazzName;
	}

	public static boolean isNull(String[] arr){
		if(arr != null && arr.length > 0){
			return false;
		}
		return true;
	}
}
