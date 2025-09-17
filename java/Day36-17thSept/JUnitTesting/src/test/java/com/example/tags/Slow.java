package com.example.tags;

import org.junit.jupiter.api.Tag;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Tag("slow")
public @interface Slow {
}
