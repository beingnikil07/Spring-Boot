package com.eazybytes.eazyschool.model;

import lombok.Data;


/*@Data annotation is a lombok library annotation which generates the getter,setters,equals(),hashcode(),
,toString() methods and constructors at compile time.
This makes our code short and clean
 */

@Data
public class Holiday  extends  BaseEntity{
        private  String day;
        private  String reason;
        private  Type type;

        public enum Type{
            FESTIVAL,FEDERAL
        }
}
