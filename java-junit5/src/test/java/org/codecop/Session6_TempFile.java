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

/**
 * Session 6: TempFile - Temporary file Extensions. <br />
 * @see "https://junit.org/junit5/docs/current/user-guide/#extensions"
 */
class Session6_TempFile implements BeforeEachCallback, ParameterResolver, AfterEachCallback {

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Temp {
        //
    }

    // TODO Call the actual logic to create and destroy the temporary file 
    // from the empty methods of the extension interfaces implemented.
    
    @Override
    public void beforeEach(ExtensionContext context) throws IOException {
        Object testInstance = context.getTestInstance();
        // TODO create a temporary file before each test
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext context) {
        Parameter parameter = parameterContext.getParameter();
        boolean parameterIsAnnotated = parameter.isAnnotationPresent(Temp.class);
        boolean parameterExpectsFile = parameter.getType() == File.class;

        return parameterIsAnnotated && parameterExpectsFile;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext context) throws ParameterResolutionException {
        // TODO return the temporary file  whenever a test method parameter has been resolved to use it.
        return null;
    }

    @Override
    public void afterEach(ExtensionContext context) {
        // TODO remove the temporary file after each test
    }
    
    // --- actual temporary file logic
    
    private File tempFile;

    private void createTempFileFor(Object testInstance) throws IOException {
        tempFile = File.createTempFile(testInstance.getClass().getSimpleName(), ".tmp");

        StringToFile.write("Keep the bar green to keep the code clean.", tempFile);
    }

    private File getTempFile() {
        if (!tempFile.exists() || tempFile.length() == 0) {
            throw new ParameterResolutionException("Could not create temp file " + tempFile);
        }
        return tempFile;
    }
    
    private void removeTempFile() {
        assertTrue(tempFile.delete()); 
    }
    
}