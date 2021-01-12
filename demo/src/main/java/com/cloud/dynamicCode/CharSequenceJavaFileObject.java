package com.cloud.dynamicCode;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;
 
/**
 * 
 * @author d
 *
 */
public class CharSequenceJavaFileObject extends SimpleJavaFileObject {
 
    private CharSequence content;
 
 
    public CharSequenceJavaFileObject(String className,
                                      CharSequence content) {
        super(URI.create("string:///" + className.replace('.', '/')
                + Kind.SOURCE.extension), Kind.SOURCE);
        this.content = content;
    }
 
    @Override
    public CharSequence getCharContent(
            boolean ignoreEncodingErrors) {
        return content;
    }
    
    @Override
    public boolean delete() {
    	content = null;
    	return true;
    }
}