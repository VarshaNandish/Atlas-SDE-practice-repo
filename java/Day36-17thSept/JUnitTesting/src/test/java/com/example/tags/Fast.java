package com.example.tags;

import org.junit.jupiter.api.Tag;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)   // Keep annotation available at runtime
@Target({ElementType.TYPE, ElementType.METHOD}) // Can be used on class or method
@Tag("fast") // JUnit5 tag
public @interface Fast {
}
