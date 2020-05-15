package com.management.spring.security.importselector;

import com.management.spring.security.getbean.MyTest;
import com.management.spring.security.interfaces.impl.InterfaceAImpl;
import com.management.spring.security.interfaces.impl.InterfaceBImpl;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author xiqiuwei
 * @Date Created in 20:42 2020/5/8
 * @Description
 * @Modified By:
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{MyTest.class.getName(), InterfaceAImpl.class.getName(), InterfaceBImpl.class.getName()};
    }
}
