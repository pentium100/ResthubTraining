// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.liwei.resthub.training.jpa_webservice.model;

import com.liwei.resthub.training.jpa_webservice.model.Menu;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Menu_Roo_Json {
    
    public String Menu.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public String Menu.toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }
    
    public static Menu Menu.fromJsonToMenu(String json) {
        return new JSONDeserializer<Menu>().use(null, Menu.class).deserialize(json);
    }
    
    public static String Menu.toJsonArray(Collection<Menu> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String Menu.toJsonArray(Collection<Menu> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Menu> Menu.fromJsonArrayToMenus(String json) {
        return new JSONDeserializer<List<Menu>>().use(null, ArrayList.class).use("values", Menu.class).deserialize(json);
    }
    
}
