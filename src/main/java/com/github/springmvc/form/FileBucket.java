/**
 * 
 */
package com.github.springmvc.form;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author budi
 *
 */
public class FileBucket {
	MultipartFile file;
    
    public MultipartFile getFile() {
        return file;
    }
 
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
