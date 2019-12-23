package com.park.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

//Converter<S, T>
//S:source,需要转换的源的类型
//T:target,需要转换的目标类型
public class CustomDateConverter implements Converter<String,Date>{

	 Logger LOG = LoggerFactory.getLogger(this.getClass());

	    private String datePattern;

	    public void setDatePattern(String datePattern) {
	        this.datePattern = datePattern;
	    }

	    @Override
	    public Date convert(String s) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
	        try {
	            Date date = dateFormat.parse(s);
	            return date;
	        }catch (ParseException e){
	            LOG.error("convertError",e);
	        }
	        return null;
	    }

}
