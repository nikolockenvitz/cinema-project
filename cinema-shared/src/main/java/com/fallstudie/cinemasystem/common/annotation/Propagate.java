/**
 * 
 */
package com.fallstudie.cinemasystem.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Propagate
{

    public enum Propagation {
        YES(1), DEPENDS(2), NO(3);
        int level;

        Propagation( int level )
        {
            this.level = level;
        }

        public int getLevel ( )
        {
            return this.level;
        }
    }

    Propagation value() default Propagation.YES;
}
