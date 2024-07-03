package pers.boot.demo.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportBySelector implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String []imports = new String[]{"pers.boot.demo.beans.ImportBean1"} ;
        return  imports ;
    }
}
