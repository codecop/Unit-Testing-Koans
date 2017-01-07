package org.codecop;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestExtensionContext;

class TempFile implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Temp {
        //
    }

    private File tempFile;

    @Override
    public void beforeEach(TestExtensionContext context) throws IOException {
        tempFile = File.createTempFile(context.getTestInstance().getClass().getSimpleName(), ".tmp");

        StringToFile.write("Keep the bar green to keep the code clean.", tempFile);
    }

    @Override
    public void afterEach(TestExtensionContext context) {
        assertTrue(tempFile.delete()); // keep
    }

    @Override
    public boolean supports(ParameterContext parameterContext, ExtensionContext context) {
        Parameter parameter = parameterContext.getParameter();
        return parameter.isAnnotationPresent(Temp.class) && parameter.getType() == File.class;
    }

    @Override
    public Object resolve(ParameterContext parameterContext, ExtensionContext context) throws ParameterResolutionException {
        if (!tempFile.exists() || tempFile.length() == 0) {
            throw new ParameterResolutionException("Could not create temp file " + tempFile);
        }
        return tempFile;
    }

}