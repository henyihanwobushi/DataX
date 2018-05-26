package com.alibaba.datax.common.element;

import com.alibaba.datax.common.util.Configuration;
import com.alibaba.datax.common.util.DefaultKeys;
import com.alibaba.fastjson.JSON;
import com.alibaba.datax.core.util.container.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by jingxing on 14-8-24.
 * <p/>
 */
public abstract class Column {

	private Type type;
	//作业的config
	private Configuration pluginJobConf;
	private Object rawData;

	private int byteSize;

	public Column(final Object object, final Type type, int byteSize) {
		//修改rawData默认值为N
		if(object.equals("")){
			this.rawData = DefaultKeys.Default_Null_Format;
		}else {
			this.rawData = object;
		}
		this.type = type;
		this.byteSize = byteSize;
	}

	public Object getRawData() {
		return this.rawData; }

	public Type getType() {
		return this.type;
	}

	public int getByteSize() {
		return this.byteSize;
	}

	protected void setType(Type type) {
		this.type = type;
	}

	protected void setRawData(Object rawData) {
		if(rawData.equals("")){
			this.rawData = DefaultKeys.Default_Null_Format;
		}else {
			this.rawData = rawData;
		}
	}

	protected void setByteSize(int byteSize) {
		this.byteSize = byteSize;
	}

	public abstract Long asLong();

	public abstract Double asDouble();

	public abstract String asString();

	public abstract Date asDate();

	public abstract byte[] asBytes();

	public abstract Boolean asBoolean();

	public abstract BigDecimal asBigDecimal();

	public abstract BigInteger asBigInteger();

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public enum Type {
		BAD, NULL, INT, LONG, DOUBLE, STRING, BOOL, DATE, BYTES
	}
}
