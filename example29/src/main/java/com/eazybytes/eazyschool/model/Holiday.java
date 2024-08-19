package com.eazybytes.eazyschool.model;

import jakarta.persistence.*;
import lombok.Data;


/*@Data annotation is a lombok library annotation which generates the getter,setters,equals(),hashcode(),
,toString() methods and constructors at compile time.
This makes our code short and clean
 */

@Data
@Entity
@Table(name="holidays")
public class Holiday  extends  BaseEntity{
        @Id
        private  String day;
        private  String reason;
        @Enumerated(EnumType.STRING)
        private  Type type;

        public enum Type{
            FESTIVAL,FEDERAL
        }
}
