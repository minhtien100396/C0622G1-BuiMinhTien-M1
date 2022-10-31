package com.minhtien.demo.utils.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
// Nếu muốn tạo annotation cho class thì dùng Type
// Nếu muốn tạo annotation cho thuộc tính thì dùng Field
// Nếu muốn tạo annotation cho phương thức thì dùng Method
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "Tên không đúng định dạng";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
