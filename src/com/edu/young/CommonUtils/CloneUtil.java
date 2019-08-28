package com.edu.young.CommonUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneUtil {
	
	/**
	 * ͨ���ֽ�������ʽ�������
	 * @param obj
	 * @return
	 */
	public static <T extends Serializable>T deepCopy(T obj) {
		T cloneObj = null;
		
		try {
			//д���ֽ���
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream obs = new ObjectOutputStream(out);
			obs.writeObject(obj);
			obs.close();
			
			//�����ڴ棬д��ԭʼ���������¶���
			ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(ios);
			
			//�������ɵĶ���
			cloneObj = (T)ois.readObject();
			ois.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cloneObj;
	}
}
